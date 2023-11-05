package io.github.shofucchi.network

import android.util.Log
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.github.shofucchi.network.api.UnsplashApi
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import javax.inject.Inject


@EntryPoint
@InstallIn(SingletonComponent::class)
interface RetrofitServiceEntryPoint {
    fun access(): RetrofitService
}

class RetrofitService @Inject constructor(
    retrofit: Retrofit,
    private val ioDispatcher: CoroutineDispatcher
) : RetrofitServiceEntryPoint {

    private val api = retrofit.create(UnsplashApi::class.java)

    override fun access(): RetrofitService {
        return this
    }

    suspend fun sync(): Boolean {
        return withContext(ioDispatcher) {
            val response = getSearchedPhotos()
            Log.d("debug", "${response.body()?.results}")
            response.isSuccessful
        }
    }

    private suspend fun getSearchedPhotos() =
        api.getSearchedPhotos(query = "cat", page = "10", id = BuildConfig.API_KEY)
}