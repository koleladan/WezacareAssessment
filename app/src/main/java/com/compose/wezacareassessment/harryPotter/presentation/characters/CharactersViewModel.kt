package com.compose.wezacareassessment.harryPotter.presentation.characters

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.compose.wezacareassessment.core.util.Resource
import com.compose.wezacareassessment.harryPotter.domain.usecases.GetCharactersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class CharactersViewModel @Inject constructor(
    private val getCharactersUseCase: GetCharactersUseCase
): ViewModel() {
    private val _state = mutableStateOf(CharactersState())
    var state: State<CharactersState> = _state

    private val _searchQuery = mutableStateOf("")
    val searchQuery: State<String> = _searchQuery
    private var searchJob: Job? = null

    init {
        getCharacters()
    }


    fun onEvent(event: CharactersEvent){
        when(event){
            is CharactersEvent.OnSearchQueryChange ->{
                _searchQuery.value = event.query
                //state = state.value.copy(searchQuery = event.query)
                searchJob?.cancel()
                searchJob = viewModelScope.launch{
                    delay(500L)
                    getCharacters()
                }
            }
        }

    }

    private fun getCharacters(
        query: String? = state.value.searchQuery?.lowercase(),
    ) {
        if (query != null) {
            getCharactersUseCase(query).onEach { result ->
                when(result){
                    is Resource.Success ->{
                        _state.value = CharactersState(characters = result.data ?: emptyList())

                    }
                    is Resource.Error ->{
                        _state.value = CharactersState(
                            error = result.message ?: "An unexpected error occurred"
                        )

                    }
                    is Resource.Loading ->{
                        _state.value = CharactersState(isLoading = true)

                    }
                }
            }.launchIn(viewModelScope)
        }

    }
}