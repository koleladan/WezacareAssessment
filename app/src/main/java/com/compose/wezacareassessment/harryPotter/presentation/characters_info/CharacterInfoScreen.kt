package com.compose.wezacareassessment.harryPotter.presentation.characters_info

import android.icu.text.CaseMap.Title
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator


@Composable
@Destination
fun CharacterInfoScreen(navigator: DestinationsNavigator

){
    val viewModel: CharacterInfoViewModel = hiltViewModel()
    val state = viewModel.state.value

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val character = state.character
        if (character != null){
            NavBar(
                title = stringResource(id = "Character's Info"),
                onBackPress = {
                    navigator.navigateUp()

                }

            )
        }

    }

}

@Composable
fun NavBar(
    title:String,
    onBackPress:() -> Unit
) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = { onBackPress()}) {
            Icon(
                painter = painterResource(id = R.drawable.backdraw),
                contentDescription = "")

        }
        Text(text = title,Modifier
            .padding(start = 75.dp),
            style = MaterialTheme.typography.subtitle2
        )




    }


}
