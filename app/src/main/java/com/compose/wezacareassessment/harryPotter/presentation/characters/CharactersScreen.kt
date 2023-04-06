package com.compose.wezacareassessment.harryPotter.presentation.characters


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
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
    Column(
        modifier = Modifier
        .fillMaxSize()
        )
     {
         state.searchQuery?.let {
             OutlinedTextField(
                 value = it,
                 onValueChange = {
                     viewModel.onEvent(
                         CharactersEvent.OnSearchQueryChange(it)
                     )
                 },
                 modifier = Modifier
                     .fillMaxWidth()
                     .padding(16.dp)
                     .clip(RoundedCornerShape(20))
                     .background(Color.LightGray),

                 placeholder = {
                     Text(text = "Search...")
                 },
                 maxLines = 1,
                 singleLine = true,

             )
         }
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

                 )
             }
             if (state.isLoading){
                 CircularProgressIndicator()
             }





         }


     }

    }

