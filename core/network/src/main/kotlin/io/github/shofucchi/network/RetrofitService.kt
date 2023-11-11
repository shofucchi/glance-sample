package io.github.shofucchi.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.github.shofucchi.network.api.UnsplashApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import javax.inject.Inject


@EntryPoint
@InstallIn(SingletonComponent::class)
interface RetrofitServiceEntryPoint {
    fun access(): RetrofitService
}

class RetrofitService @Inject constructor(json: Json) : RetrofitServiceEntryPoint {

    companion object {
        private const val URL = "https://api.unsplash.com/"
    }

    private val api = Retrofit.Builder()
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(URL)
        .build()
        .create(UnsplashApi::class.java)

    override fun access(): RetrofitService {
        return this
    }

    suspend fun getSearchedPhotos() =
        api.getSearchedPhotos(query = "cat", page = "10", id = BuildConfig.API_KEY).body()
}