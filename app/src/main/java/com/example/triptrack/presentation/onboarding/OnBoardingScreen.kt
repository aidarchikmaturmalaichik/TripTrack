package com.example.triptrack.presentation.onboarding

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.example.triptrack.presentation.component.BottomComponent
import com.example.triptrack.presentation.order_screen.FirstEntryScreen

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingScreen(
    event: (OnBoardingEvent) -> Unit,
) {
    val pagerState = rememberPagerState(
        initialPage = 0,
        pageCount = { pagesList.size },
    )
    val buttonState = remember {
        derivedStateOf {
            when (pagerState.currentPage) {
                0 -> listOf<String>("", "Далее")
                1 -> listOf<String>("Назад", "Далее")
                2 -> listOf<String>("Назад", "Далее")
                3 -> listOf("", "")
                else -> listOf<String>("", "Далее")
            }
        }
    }

    val beyondBoundsPageCount = 1

    HorizontalPager(
        modifier = Modifier.fillMaxSize(),
        state = pagerState,
        // beyondBoundsPageCount = beyondBoundsPageCount
    ) { index ->
        when (index) {
            pagesList.lastIndex -> FirstEntryScreen(onEvent = event)
            else -> OnBoardingPage(page = pagesList[index])
        }
    }
    BottomComponent(
        pageSize = pagesList.size,
        pagerState = pagerState,
        buttonValue = buttonState.value,
    )
}
