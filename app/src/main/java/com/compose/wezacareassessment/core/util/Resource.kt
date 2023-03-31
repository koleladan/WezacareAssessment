package com.compose.wezacareassessment.core.util

import com.compose.wezacareassessment.harryPotter.domain.model.Characters

sealed class Resource<T>(val data: Any? = null, val message:String? = null){
    class Success<T>(data: List<Characters>? = null): Resource<T>(data)
    class  Error<T>(data: T? = null, message: String? = null): Resource<T>(data, message)
    class Loading<T>(val isLoading: Boolean = true): Resource<T>(data = null)
}
