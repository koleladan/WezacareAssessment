package com.compose.wezacareassessment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.compose.wezacareassessment.harryPotter.presentation.Screens
import com.compose.wezacareassessment.harryPotter.presentation.characters.CharactersScreen
import com.compose.wezacareassessment.harryPotter.presentation.characters_info.CharacterInfoScreen
import com.compose.wezacareassessment.ui.theme.WezacareassessmentTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WezacareassessmentTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screens.CharactersScreen.route )
                    {
                        composable(
                            route = Screens.CharactersScreen.route
                        ){
                            CharactersScreen(navController)
                        }
                        composable(
                            route = Screens.CharacterInfoscreen.route + "/{characterId}"
                        ){
                            CharacterInfoScreen()
                        }

                    }



                }
            }
        }
    }
}

