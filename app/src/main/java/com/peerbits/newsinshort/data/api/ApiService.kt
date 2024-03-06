package com.peerbits.newsinshort.data.api

import com.peerbits.newsinshort.data.entity.NewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

val API_KEY = "d04040e4144c4e6eac6ee6e9b4f53ad9"

interface ApiService {

    @GET("v2/top-headlines")
    suspend fun getNewsHeadline(
        @Query("country")
        countryCode: String, //= "us",
        @Query("apiKey")
        apiKey: String = API_KEY
    ): Response<NewsResponse>
}