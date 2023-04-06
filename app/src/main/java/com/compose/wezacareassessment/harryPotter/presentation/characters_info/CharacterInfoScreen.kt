package com.compose.wezacareassessment.harryPotter.presentation.characters_info

import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.compose.wezacareassessment.harryPotter.domain.model.CharacterInfo
import com.google.gson.Gson
import com.ramcosta.composedestinations.annotation.Destination
import com.compose.wezacareassessment.R



@Composable
@Destination
fun CharacterInfoScreen(id:String)
   {
    val viewModel: CharacterInfoViewModel = hiltViewModel()
       val info = Gson().fromJson(id,CharacterInfo::class.java)
       viewModel.updateCharacter(characterInfo = info)
    val state = viewModel.state.value


    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val character = state.character
        if (character != null){
            character.name?.let {
                Text(
                    text = it,
                    style = MaterialTheme.typography.h6,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(20.dp))
               if (character.image.isNullOrEmpty()){
                   Image(
                       painterResource(id = R.drawable.image_not_available) ,
                       contentDescription = "",
                       modifier = Modifier
                           .height(250.dp)
                   )

               }else {
                   AsyncImage(
                       model = character.image,
                       contentDescription = "Character's Image",
                       modifier = Modifier
                           .height(350.dp)
                           .fillMaxWidth()


                   )
               }
                Spacer(modifier = Modifier.height(20.dp))
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(start = 8.dp)
                ) {
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

                    val alternateNameStringStyle = listOf(
                        AnnotatedString.Range(
                            SpanStyle(fontWeight = FontWeight.Bold),
                            start = 0,
                            end = 16
                        )
                    )
                    val alternateNamesString = "Alternate_Names: ${character.alternate_names}"
                    Text(
                        text = AnnotatedString(text = alternateNamesString, spanStyles = alternateNameStringStyle),
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
                    val alternateActorsStringStyle = listOf(
                        AnnotatedString.Range(
                            SpanStyle(fontWeight = FontWeight.Bold),
                            start = 0,
                            end = 17
                        )
                    )
                    val alternateActorsString = "Alternate_Actors: ${character.alternate_actors}"
                    Text(
                        text = AnnotatedString(text = alternateActorsString, spanStyles = alternateActorsStringStyle),
                        color = Color.Black,
                        modifier = Modifier.padding(start = 10.dp, top = 2.dp)
                    )
                    val eyeColourStringStyle = listOf(
                        AnnotatedString.Range(
                            SpanStyle(fontWeight = FontWeight.Bold),
                            start = 0,
                            end = 11
                        )
                    )
                    val eyeColourString = "Eye Colour: ${character.eyeColour}"
                    Text(
                        text = AnnotatedString(text = eyeColourString, spanStyles = eyeColourStringStyle),
                        color = Color.Black,
                        modifier = Modifier.padding(start = 10.dp, top = 2.dp)
                    )

                    val hairColourStringStyle = listOf(
                        AnnotatedString.Range(
                            SpanStyle(fontWeight = FontWeight.Bold),
                            start = 0,
                            end = 12
                        )
                    )
                    val hairColourString = "Hair Colour: ${character.hairColour}"
                    Text(
                        text = AnnotatedString(text = hairColourString, spanStyles = hairColourStringStyle),
                        color = Color.Black,
                        modifier = Modifier.padding(start = 10.dp, top = 2.dp)
                    )

                    val hogwartsStaffStringStyle = listOf(
                        AnnotatedString.Range(
                            SpanStyle(fontWeight = FontWeight.Bold),
                            start = 0,
                            end = 15
                        )
                    )
                    val hogwartsStaffString = "Hogwarts Staff: ${character.hogwartsStaff}"
                    Text(
                        text = AnnotatedString(text = hogwartsStaffString, spanStyles = hogwartsStaffStringStyle),
                        color = Color.Black,
                        modifier = Modifier.padding(start = 10.dp, top = 2.dp)
                    )

                    val hogwartsStudentStringStyle = listOf(
                        AnnotatedString.Range(
                            SpanStyle(fontWeight = FontWeight.Bold),
                            start = 0,
                            end = 17
                        )
                    )
                    val hogwartsStudentString = "Hogwarts Student: ${character.hogwartsStudent}"
                    Text(
                        text = AnnotatedString(text = hogwartsStudentString, spanStyles = hogwartsStudentStringStyle),
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

                    val wizardStringStyle = listOf(
                        AnnotatedString.Range(
                            SpanStyle(fontWeight = FontWeight.Bold),
                            start = 0,
                            end = 7
                        )
                    )
                    val wizardString = "Wizard: ${character.wizard}"
                    Text(
                        text = AnnotatedString(text = wizardString, spanStyles = wizardStringStyle),
                        color = Color.Black,
                        modifier = Modifier.padding(start = 10.dp, top = 2.dp)
                    )



                }
            }


        }




    }

}

