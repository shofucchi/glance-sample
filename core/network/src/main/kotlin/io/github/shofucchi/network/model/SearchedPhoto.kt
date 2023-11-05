package io.github.shofucchi.network.model

import kotlinx.serialization.Serializable

@Serializable
data class SearchedPhoto(
    val results: List<Result>
)
