package com.compose.wezacareassessment.harryPotter.data.remote.dto

import com.compose.wezacareassessment.harryPotter.domain.model.CharacterInfo
import com.compose.wezacareassessment.harryPotter.domain.model.Wand

data class CharacterInfoDto(
    val actor: String?,
    val alive: Boolean?,
    val alternate_actors: List<String>?,
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
fun CharacterInfoDto.toCharacterInfo(): CharacterInfo{
    return CharacterInfo(
        actor =actor,
        alive = alive,
        alternate_actors = alternate_actors,
        alternate_names = alternate_names,
        ancestry = ancestry,
        dateOfBirth = dateOfBirth,
        eyeColour = eyeColour,
        gender = gender,
        hairColour = hairColour,
        hogwartsStaff = hogwartsStaff,
        hogwartsStudent = hogwartsStudent,
        house = house,
        characterId = id,
        image = image,
        name = name,
        patronus = patronus,
        species = species,
        wizard = wizard,
        yearOfBirth = yearOfBirth
    )
}