package com.peerbits.newsinshort.ui.repository

import android.util.Log
import com.peerbits.newsinshort.data.datasource.NewsDataSource
import com.peerbits.newsinshort.data.entity.NewsResponse
import com.peerbits.utilities.ResourceState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class NewsRepository @Inject constructor(
    private val newsDataSource: NewsDataSource
) {

//    suspend fun getNewsHeadline(countryCode:String) : Response<NewsResponse>{
//        return newsDataSource.getNewsHeadline(countryCode)
//    }

    suspend fun getNewsHeadline(countryCode: String): Flow<ResourceState<NewsResponse>> {
        return flow {
            emit(ResourceState.Loading())

            val response = newsDataSource.getNewsHeadline(countryCode)

            if (response.isSuccessful && response.body() != null) {
                emit(ResourceState.Success(response.body()!!))
            } else {
                emit(ResourceState.Error("Error fetching news data"))
            }
        }.catch { e ->
            emit(ResourceState.Error(e?.localizedMessage ?: "Some error in flow"))
        }
    }
}