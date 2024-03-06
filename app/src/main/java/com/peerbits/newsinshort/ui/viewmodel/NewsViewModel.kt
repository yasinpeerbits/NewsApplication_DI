package com.peerbits.newsinshort.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.peerbits.newsinshort.data.AppConstants
import com.peerbits.newsinshort.data.entity.NewsResponse
import com.peerbits.newsinshort.ui.repository.NewsRepository
import com.peerbits.utilities.ResourceState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val newsRepository: NewsRepository
) : ViewModel() {

    private val _news: MutableStateFlow<ResourceState<NewsResponse>> =
        MutableStateFlow(ResourceState.Loading())

    val news: StateFlow<ResourceState<NewsResponse>> = _news

    init {
        getNews(AppConstants.COUNTRY)
    }

    fun getNews(countryCode: String) {
        Log.d("COUNTRYCODE",countryCode.toString())
        viewModelScope.launch(Dispatchers.IO) {
            newsRepository.getNewsHeadline(countryCode)
                .collectLatest {newsResponse ->
                    Log.d("NEWSRESPONSE", newsResponse.toString())
                    _news.value = newsResponse
            }
        }
    }


    companion object {
        const val TAG = "NewsViewModel"
    }
}