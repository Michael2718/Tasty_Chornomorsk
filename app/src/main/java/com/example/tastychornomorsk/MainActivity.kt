package com.example.tastychornomorsk

import android.content.res.Resources
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.tastychornomorsk.ui.screens.TastyChornomorskApp
import com.example.tastychornomorsk.ui.theme.TastyChornomorskTheme
import java.util.Locale

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setDefaultLocale(resources, "uk")
        setContent {
            TastyChornomorskTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val windowSize = calculateWindowSizeClass(this)
                    TastyChornomorskApp(windowSize.widthSizeClass)
                }
            }
        }
    }
}

private fun MainActivity.setDefaultLocale(resources: Resources, localeString: String) {
    val config = resources.configuration
    val locale = Locale(localeString)
    Locale.setDefault(locale)
    config.setLocale(locale)
    createConfigurationContext(config)
    @Suppress("DEPRECATION")
    resources.updateConfiguration(config, resources.displayMetrics) // resources.updateConfiguration() is deprecated, but it works
}


@Preview(showBackground = true)
@Composable
fun TastyChornomorskAppCompactPreview() {
    TastyChornomorskTheme {
        TastyChornomorskApp(WindowWidthSizeClass.Compact)
    }
}
