package io.github.shofucchi.network

import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.runTest
import kotlinx.serialization.json.Json
import org.junit.Before
import org.junit.Test

class RetrofitServiceTest {

    private lateinit var retrofitService: RetrofitService

    private val testDispatcher = StandardTestDispatcher()

    @Before
    fun setUp() {
        retrofitService = RetrofitService(Json { ignoreUnknownKeys = true })
    }

    @Test
    fun testNetworkIsSuccessful() = runTest(testDispatcher) {
        val searchedPhoto = retrofitService.getSearchedPhotos()
        val results = searchedPhoto?.results
        val url = results?.get(0)?.urls
        val regular = url?.regular
        assertThat(searchedPhoto).isNotNull()
        assertThat(results).isNotNull()
        assertThat(url).isNotNull()
        assertThat(regular).isNotNull()
    }
}