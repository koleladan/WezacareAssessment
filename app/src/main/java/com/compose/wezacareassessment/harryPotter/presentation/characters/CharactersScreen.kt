package com.compose.wezacareassessment.harryPotter.presentation.characters


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Composable
@Destination(start = true)
fun CharactersScreen(
    navigator: DestinationsNavigator,
    viewModel: CharactersViewModel = hiltViewModel()

) {
    val state = viewModel.state.value
    Box(modifier = Modifier
        .fillMaxSize()
    ) {

//            state.searchQuery?.let { it ->
//                OutlinedTextField(
//                    value = it,
//                    onValueChange = {
//                        viewModel.onEvent(
//                            CharactersEvent.OnSearchQueryChange(it)
//                        )
//                    },
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(16.dp),
//                    placeholder = {
//                        Text(text = "Search...")
//                    },
//                    maxLines = 1,
//                    singleLine = true
//                )
//            }
        LazyColumn(modifier = Modifier.fillMaxSize()
        ) {
            items(state.characters) { character ->
                CharactersItem(
                    navigator,
                    character = character
                )

            }
        }

        if (state.error?.isNotBlank() == true) {
            state.error?.let {
                Text(
                    text = it,
                    color = MaterialTheme.colors.error,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                        .align(Alignment.Center)
                )
            }
            if (state.isLoading){
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }



//            state.characters?.size.let {
//                    items(it.size) { i ->
//                        val character = it[i]
//                            CharactersItem(
//                                navigator,
//                                character = character,
//                                modifier = Modifier
//                                    .fillMaxSize()
//                                    .padding(16.dp)
//
//                            )
//                        }
//
//                    }




        }

    }
}