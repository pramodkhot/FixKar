package com.fixkar.app.ui.navigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.fixkar.app.R

/**
 * App-wide navigation graph. New screens are added as composables here.
 *
 * Phase 2 will add:
 *   - Route.Splash
 *   - Route.Login
 *   - Route.OtpVerify
 *   - Route.RoleSelection
 *   - Route.Home
 */
object Routes {
    const val HOME = "home"
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.HOME
    ) {
        composable(Routes.HOME) {
            HomePlaceholderScreen()
        }
    }
}

/**
 * Phase 1 placeholder. Proves:
 *   - The app compiles and runs.
 *   - Theme is applied.
 *   - String resources load.
 *   - Navigation graph works.
 *
 * Will be replaced in Phase 2 by the Login / Splash flow.
 */
@Composable
private fun HomePlaceholderScreen() {
    Scaffold { inner ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(inner)
                .padding(24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = stringResource(id = R.string.app_name),
                style = MaterialTheme.typography.displayLarge,
                color = MaterialTheme.colorScheme.primary,
            )
            Text(
                text = stringResource(id = R.string.phase1_tagline),
                style = MaterialTheme.typography.titleMedium,
            )
        }
    }
}
