package com.peerbits.newsinshort.data.datasource

import com.peerbits.newsinshort.data.api.ApiService
import com.peerbits.newsinshort.data.entity.NewsResponse
import retrofit2.Response
import javax.inject.Inject

class NewsDataSourceImpl @Inject constructor(
    private val apiService: ApiService
) : NewsDataSource {
    override suspend fun getNewsHeadline(countryCode: String): Response<NewsResponse> {
        return apiService.getNewsHeadline(countryCode)
    }
}