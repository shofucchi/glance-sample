package io.github.shofucchi.network

interface Synchronizer {
    suspend fun synchronize()
}