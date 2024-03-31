package com.iscms.themoviejetpack.ui.screen.home

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun HomeScreen() {
    Scaffold(topBar = {
        MainAppBar()
    }) { padding ->
        MediaList(modifier = Modifier.padding(padding))
    }
}