package com.compose.wezacareassessment.harryPotter.presentation.characters_info

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.compose.wezacareassessment.core.util.Resource
import com.compose.wezacareassessment.harryPotter.data.remote.Apiservice
import com.compose.wezacareassessment.harryPotter.domain.model.CharacterInfo
import com.compose.wezacareassessment.harryPotter.domain.usecases.GetCharactersInfoUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterInfoViewModel @Inject constructor(

    private val getCharactersInfoUseCases: GetCharactersInfoUseCases,
    savedStateHandle: SavedStateHandle
):ViewModel() {
    private val _state = mutableStateOf(CharactersInfoState())
    val  state: State<CharactersInfoState> get() = _state

    init {
        savedStateHandle.get<String>(Apiservice.CHAR_ID)?.let { characterId ->
            getCharacterInfo(characterId)
        }
    }

    fun updateCharacter(characterInfo: CharacterInfo){
        _state.value = CharactersInfoState(character = characterInfo)
    }


    private fun getCharacterInfo(characterId:String) {
        viewModelScope.launch {
            getCharactersInfoUseCases(characterId)
                .collect { result ->
                    when(result) {
                        is Resource.Success -> {
                            _state.value = CharactersInfoState( character = result.data)
                        }
                        is Resource.Error -> {
                            _state.value = CharactersInfoState(
                                error = result.message ?: "An unexpected occurred"
                            )
                        }
                        is Resource.Loading -> {
                            _state.value = CharactersInfoState(isLoading = true)
                        }

                    }


                }
        }

    }
}