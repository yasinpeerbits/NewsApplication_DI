package com.peerbits.newsinshort.data.datasource

import com.peerbits.newsinshort.data.entity.NewsResponse
import retrofit2.Response

interface NewsDataSource {
    suspend fun getNewsHeadline(countryCode: String): Response<NewsResponse>
}