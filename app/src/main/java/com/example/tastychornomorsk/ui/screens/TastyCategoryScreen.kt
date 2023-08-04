package com.example.tastychornomorsk.ui.screens

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.tastychornomorsk.ui.TastyViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TastyChornomorskApp(
    windowSize: WindowWidthSizeClass,
    modifier: Modifier = Modifier
) {
    val viewModel: TastyViewModel = viewModel()
    val uiState by viewModel.uiState.collectAsState()

    // ContentType

//    Scaffold(
//        topBar = {
//            TastyAppBar(
//                onBackButtonClick = { /*TODO*/ },
//                windowSize = windowSize
//            )
//        }
//    ) { innerPadding ->
//
//    }
}

@Composable
fun TastyAppBar(
    onBackButtonClick: () -> Unit,
    windowSize: WindowWidthSizeClass,
    modifier: Modifier = Modifier
) {

}