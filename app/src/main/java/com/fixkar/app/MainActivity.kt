package com.fixkar.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.fixkar.app.ui.navigation.AppNavigation
import com.fixkar.app.ui.theme.FixKarTheme
import dagger.hilt.android.AndroidEntryPoint

/**
 * Single Activity for the entire app (standard for Compose apps).
 * Hosts the Compose tree. Navigation between screens happens inside [AppNavigation].
 *
 * @AndroidEntryPoint — tells Hilt to inject dependencies into this Activity.
 */
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()   // draws content behind status/nav bars for a modern look
        setContent {
            FixKarTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    AppNavigation()
                }
            }
        }
    }
}
