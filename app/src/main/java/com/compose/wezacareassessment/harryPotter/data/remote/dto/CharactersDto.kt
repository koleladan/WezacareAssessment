package com.compose.wezacareassessment.harryPotter.data.remote.dto

import com.compose.wezacareassessment.harryPotter.domain.model.Characters
import com.compose.wezacareassessment.harryPotter.domain.model.Wand

data class CharactersDto(
    val actor: String?,
    val alive: Boolean?,
    val alternate_actors: List<Any>?,
    val alternate_names: List<String>?,
    val ancestry: String?,
    val dateOfBirth: String?,
    val eyeColour: String?,
    val gender: String?,
    val hairColour: String?,
    val hogwartsStaff: Boolean?,
    val hogwartsStudent: Boolean?,
    val house: String?,
    val id: String?,
    val image: String?,
    val name: String?,
    val patronus: String?,
    val species: String?,
    val wand: Wand?,
    val wizard: Boolean?,
    val yearOfBirth: Int?
)
fun CharactersDto.toCharacters(): Characters{
    return Characters(
        actor = actor,
        alive = alive,
        ancestry = ancestry,
        dateOfBirth = dateOfBirth,
        gender = gender,
        id = id,
        image = image,
        species = species,
        name = name
    )
}