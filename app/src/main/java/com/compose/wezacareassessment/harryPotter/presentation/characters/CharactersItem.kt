package com.compose.wezacareassessment.harryPotter.presentation.characters

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.compose.wezacareassessment.harryPotter.domain.model.Characters
import com.compose.wezacareassessment.harryPotter.presentation.destinations.CharacterInfoScreenDestination
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.compose.wezacareassessment.R
import com.google.gson.Gson


@OptIn(ExperimentalMaterialApi::class)
@Composable
@Destination
fun CharactersItem(
    navigator: DestinationsNavigator,
    character: Characters,
    modifier: Modifier = Modifier
){
    fun navigateToCharacter(id: String){ navigator.navigate(CharacterInfoScreenDestination(id = id))}
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .clip(RoundedCornerShape(10)),
        backgroundColor = Color.LightGray,
        elevation = 4.dp,
        onClick = {
            val gson = Gson().toJson(character)
            character.id?.let { navigateToCharacter(id = gson) }


        }

    ){
        Row(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
        ) {
            if (character.image.isNullOrEmpty()){
                Image(painterResource(id = R.drawable.image_not_available ),
                    contentDescription = "",
                    modifier = Modifier
                        .height(200.dp)
                        .width(145.dp)
                )
            }else{
                AsyncImage(
                    model = character.image,
                    contentDescription = "Character's Image",
                    modifier = Modifier
                        .height(200.dp)

                )
            }
            Column(modifier = Modifier
                .fillMaxHeight()
                .padding(top = 2.dp, start = 8.dp)
            ) {
                character.name?.let {
                    Text(
                        text = it,
                        style = MaterialTheme.typography.h6,
                        textAlign = TextAlign.Center,
                        color = Color.Black,
                        modifier = modifier
                            .padding(start = 8.dp)
                            .fillMaxWidth()


                    )
                }

                val ancestryStringStyle = listOf(
                    AnnotatedString.Range(
                        SpanStyle(fontWeight = FontWeight.Bold),
                        start = 0,
                        end = 9
                    )
                )
                val ancestryString = "Ancestry: ${character.ancestry}"
                Text(
                    text = AnnotatedString(text = ancestryString, spanStyles = ancestryStringStyle),
                    color = Color.Black,
                    modifier = Modifier.padding(start = 10.dp, top = 2.dp)
                )

                val genderStringStyle = listOf(
                    AnnotatedString.Range(
                        SpanStyle(fontWeight = FontWeight.Bold),
                        start = 0,
                        end = 7
                    )
                )
                val genderString = "Gender: ${character.gender}"
                Text(
                    text = AnnotatedString(text = genderString, spanStyles = genderStringStyle),
                    color = Color.Black,
                    modifier = Modifier.padding(start = 10.dp, top = 2.dp)
                )

                val speciesStringStyle = listOf(
                    AnnotatedString.Range(
                        SpanStyle(fontWeight = FontWeight.Bold),
                        start = 0,
                        end = 8
                    )
                )
                val speciesString = "Species: ${character.species}"
                Text(
                    text = AnnotatedString(text = speciesString, spanStyles = speciesStringStyle),
                    color = Color.Black,
                    modifier = Modifier.padding(start = 10.dp, top = 2.dp)
                )

                val dateOfBirthStringStyle = listOf(
                    AnnotatedString.Range(
                        SpanStyle(fontWeight = FontWeight.Bold),
                        start = 0,
                        end = 14
                    )
                )
                val dateOfBirthString = "Date of Birth: ${character.dateOfBirth}"
                Text(
                    text = AnnotatedString(text = dateOfBirthString, spanStyles = dateOfBirthStringStyle),
                    color = Color.Black,
                    modifier = Modifier.padding(start = 10.dp, top = 2.dp)
                )

                val aliveStringStyle = listOf(
                    AnnotatedString.Range(
                        SpanStyle(fontWeight = FontWeight.Bold),
                        start = 0,
                        end = 6
                    )
                )
                val aliveString = "Alive: ${character.alive}"
                Text(
                    text = AnnotatedString(text = aliveString, spanStyles = aliveStringStyle),
                    color = Color.Black,
                    modifier = Modifier.padding(start = 10.dp, top = 2.dp)
                )

                val actorStringStyle = listOf(
                    AnnotatedString.Range(
                        SpanStyle(fontWeight = FontWeight.Bold),
                        start = 0,
                        end = 6
                    )
                )
                val actorString = "Actor: ${character.actor}"
                Text(
                    text = AnnotatedString(text = actorString, spanStyles = actorStringStyle),
                    color = Color.Black,
                    modifier = Modifier.padding(start = 10.dp, top = 2.dp)
                )
                val houseStringStyle = listOf(
                    AnnotatedString.Range(
                        SpanStyle(fontWeight = FontWeight.Bold),
                        start = 0,
                        end = 6
                    )
                )
                val houseString = "House: ${character.house}"
                Text(
                    text = AnnotatedString(text = houseString, spanStyles = houseStringStyle),
                    color = Color.Black,
                    modifier = Modifier.padding(start = 10.dp, top = 2.dp)
                )



            }

        }

    }

}