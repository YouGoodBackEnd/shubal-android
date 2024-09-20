package com.danguback.shubal.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.danguback.core.data.util.NetworkMonitor
import kotlinx.coroutines.CoroutineScope

@Stable
class ShubalAppState(
    val navController: NavHostController,
    coroutineScope: CoroutineScope,
    networkMonitor: NetworkMonitor
) {
    val currentDestination: NavDestination?
        @Composable get() = navController
            .currentBackStackEntryAsState().value?.destination

  //  val currentTopLevelDestination:

}