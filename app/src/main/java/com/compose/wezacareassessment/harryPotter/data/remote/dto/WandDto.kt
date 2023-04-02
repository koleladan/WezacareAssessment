package com.compose.wezacareassessment.harryPotter.data.remote.dto

import com.compose.wezacareassessment.harryPotter.domain.model.Wand

data class WandDto(
    val core: String?,
    val length: Double?,
    val wood: String?
)
fun WandDto.toWand(): Wand{
    return Wand(
        core =core,
        length = length,
        wood =wood
    )
}