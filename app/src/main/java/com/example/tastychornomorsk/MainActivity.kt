package com.example.tastychornomorsk

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tastychornomorsk.data.LocalPlacesDataProvider
import com.example.tastychornomorsk.ui.screens.PlaceDetail
import com.example.tastychornomorsk.ui.screens.TastyChornomorskApp
import com.example.tastychornomorsk.ui.theme.TastyChornomorskTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TastyChornomorskTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val windowSize = calculateWindowSizeClass(this)
//                    TastyChornomorskApp(windowSize.widthSizeClass)
                    PlaceDetail(
                        selectedPlace = LocalPlacesDataProvider.getPlacesData()[1],
                        onBackPressed = {},
                        modifier = Modifier.padding(8.dp)
                    )
                }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun TastyChornomorskAppCompactPreview() {
    TastyChornomorskTheme {
        TastyChornomorskApp(WindowWidthSizeClass.Compact)
    }
}