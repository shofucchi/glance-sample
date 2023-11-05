package io.github.shofucchi.network.model

import kotlinx.serialization.Serializable

@Serializable
data class Result(
    val urls: Url
)
