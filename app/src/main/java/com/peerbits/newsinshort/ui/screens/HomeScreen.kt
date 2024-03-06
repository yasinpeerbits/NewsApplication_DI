package com.peerbits.newsinshort.ui.screens

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.peerbits.newsinshort.ui.components.EmptyStateComponent
import com.peerbits.newsinshort.ui.components.Loader
import com.peerbits.newsinshort.ui.components.NewsRowComponent
import com.peerbits.newsinshort.ui.viewmodel.NewsViewModel
import com.peerbits.utilities.ResourceState

const val TAG = "HomeScreen"

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    newsViewModel: NewsViewModel = hiltViewModel()
) {

    val newsRes by newsViewModel.news.collectAsState()

    val pagerState = rememberPagerState(
        initialPage = 0,
        initialPageOffsetFraction = 0f
    ) {
        when (val newsData = newsRes) {
            is ResourceState.Success -> {
                newsData.data.articles.size
            }

            else -> 1 // Set a default value or handle other cases
        }
    }
    VerticalPager(
        state = pagerState,
        modifier = Modifier.fillMaxSize(),
        pageSize = PageSize.Fill,
        pageSpacing = 8.dp
    ) { page: Int ->
        when (newsRes) {
            is ResourceState.Loading -> {
                Log.d(TAG, "Inside Loading")
                Loader()
            }

            is ResourceState.Success -> {
                val response = (newsRes as ResourceState.Success).data
                Log.d(TAG, "Inside Success ${response.status} = ${response.totalResults}")
                //NewsList(response, page)
                if (response.articles.isNotEmpty()) {
                NewsRowComponent(page, response.articles.get(page))

                }else{
                    EmptyStateComponent()
                }
            }

            is ResourceState.Error -> {
                Log.d(TAG, "Inside Error")
            }
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}