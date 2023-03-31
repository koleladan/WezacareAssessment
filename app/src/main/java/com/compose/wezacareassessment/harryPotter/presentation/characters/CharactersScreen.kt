package com.compose.wezacareassessment.harryPotter.presentation.characters

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Composable
@Destination(start = true)
fun CharactersScreen(
    navigator: DestinationsNavigator,
    viewModel: CharactersViewModel = hiltViewModel()

){
    val state = viewModel.state
    Column(modifier = Modifier.fillMaxSize()
    ) {

            state.searchQuery?.let { it ->
                OutlinedTextField(
                    value = it,
                    onValueChange = {
                        viewModel.onEvent(
                            CharactersEvent.OnSearchQueryChange(it)
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    placeholder = {
                        Text(text = "Search...")
                    },
                    maxLines = 1,
                    singleLine = true
                )
            }
        LazyColumn(modifier = Modifier.fillMaxSize()
        ){
            state.characters?.size.let {
                if (it != null) {
                    items(it){ i ->
                        val character = state.characters?.get(i)
                        if (character != null) {
                            CharactersItem(
                                character = character,
                                modifier = Modifier
                                    .fillMaxSize()
                                    .clickable {
                                        //TODO
                                    }
                                    .padding(16.dp)
                            )
                        }
                        if (i < state.characters?.size!!){
                            Divider(modifier = Modifier.padding(
                                horizontal = 16.dp
                            ))
                        }

                    }
                }
            }


        }

    }
}