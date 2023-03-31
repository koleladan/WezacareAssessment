package com.compose.wezacareassessment.harryPotter.presentation.characters

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.compose.wezacareassessment.core.util.Resource
import com.compose.wezacareassessment.harryPotter.domain.model.Characters
import com.compose.wezacareassessment.harryPotter.domain.repository.CharactersRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class CharactersViewModel @Inject constructor(
    private val repository: CharactersRepository
): ViewModel() {
     var state by mutableStateOf(CharactersState())
    private var searchJob: Job? = null

    init {
        getCharacters()
    }


    fun onEvent(event: CharactersEvent){
        when(event){
            is CharactersEvent.OnSearchQueryChange ->{
                state = state.copy(searchQuery = event.query)
                searchJob?.cancel()
                searchJob = viewModelScope.launch{
                    delay(500L)
                    getCharacters()
                }
            }
        }

    }

    private fun getCharacters(
        query: String? = state.searchQuery?.lowercase()
    ) {
        viewModelScope.launch {
            if (query != null) {
                repository
                    .getAllCharacters(query)
                    .collect{result->
                        when(result){
                            is Resource.Success ->{
                                result.data?. let { items ->
                                    state = state.copy(
                                        characters = items as List<Characters>
                                    )
                                }
                            }
                            is Resource.Error -> Unit
                            is Resource.Loading ->{
                                state = state.copy(
                                    isLoading = result.isLoading
                                )
                            }
                        }


                    }
            }
        }

    }
}