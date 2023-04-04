package com.compose.wezacareassessment.harryPotter.presentation.characters_info

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.compose.wezacareassessment.core.util.Resource
import com.compose.wezacareassessment.harryPotter.data.remote.Apiservice
import com.compose.wezacareassessment.harryPotter.data.remote.Apiservice.Companion.CHAR_ID
import com.compose.wezacareassessment.harryPotter.domain.usecases.GetCharactersInfoUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CharacterInfoViewModel @Inject constructor(
    private val getCharactersInfoUseCases: GetCharactersInfoUseCases,
    savedStateHandle: SavedStateHandle
):ViewModel() {
    private val _state = mutableStateOf(CharactersInfoState())
    val  state: State<CharactersInfoState> = _state

    init {
        savedStateHandle.get<String>(Apiservice.CHAR_ID)?.let { characterId ->
            getCharacterInfo(characterId)
        }
    }


    private fun getCharacterInfo(characterId:String) {
            getCharactersInfoUseCases(characterId).onEach { result ->
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