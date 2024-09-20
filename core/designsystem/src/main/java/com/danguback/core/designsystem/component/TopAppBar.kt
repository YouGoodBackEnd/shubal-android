package com.danguback.core.designsystem.component

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.danguback.core.designsystem.icon.ShubalIcons
import com.danguback.core.designsystem.theme.Background
import com.danguback.core.designsystem.theme.Primary400
import com.danguback.core.designsystem.theme.ShubalTheme
import com.danguback.core.designsystem.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShubalCenterAlignedTopAppBar(
    @StringRes titleRes: Int,
    navigationIcon: ImageVector,
    navigationIconContentDescription: String,
    actionIcon: ImageVector,
    actionIconContentDescription: String,
    modifier: Modifier = Modifier,
    colors: TopAppBarColors = TopAppBarDefaults.centerAlignedTopAppBarColors,
    expandedHeight: Dp = TopAppBarDefaults.topAppBarExpandedHeight,
    onNavigationClick: () -> Unit = {},
    onActionClick: () -> Unit = {},
) {
    CenterAlignedTopAppBar(
        title = { Text(text = stringResource(id = titleRes)) },
        navigationIcon = {
            IconButton(onClick = onNavigationClick) {
                Icon(
                    imageVector = navigationIcon,
                    contentDescription = navigationIconContentDescription,
                )
            }
        },
        actions = {
            IconButton(onClick = onActionClick) {
                Icon(
                    imageVector = actionIcon,
                    contentDescription = actionIconContentDescription,
                )
            }
        },
        expandedHeight = expandedHeight,
        colors = colors,
        modifier = modifier.testTag("ShubalCenterAlignedTopAppBar"),
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShubalTopAppBar(
    @StringRes titleRes: Int,
    navigationIcon: ImageVector,
    navigationIconContentDescription: String,
    actionIcon: ImageVector,
    actionIconContentDescription: String,
    modifier: Modifier = Modifier,
    colors: TopAppBarColors = TopAppBarDefaults.centerAlignedTopAppBarColors,
    expandedHeight: Dp = TopAppBarDefaults.topAppBarExpandedHeight,
    onNavigationClick: () -> Unit = {},
    onActionClick: () -> Unit = {},
) {
    Row(
        modifier = modifier
            .height(expandedHeight)
            .fillMaxSize()
            .background(colors.containerColor),
        verticalAlignment = Alignment.CenterVertically,
        //horizontalArrangement = Arrangement.SpaceBetween
    ) {
        IconButton(onClick = onNavigationClick) {
            Icon(
                imageVector = navigationIcon,
                tint = colors.navigationIconContentColor,
                contentDescription = navigationIconContentDescription,
            )
        }
        Spacer(modifier = modifier.width(16.dp))
        TextField(value = "", onValueChange = {}, modifier.fillMaxWidth())
    }
    /* TopAppBar(
         title = { Text(text = stringResource(id = titleRes)) },
         navigationIcon = {
             IconButton(onClick = onNavigationClick) {
                 Icon(
                     imageVector = navigationIcon,
                     contentDescription = navigationIconContentDescription,
                 )
             }
         },
         actions = {
             IconButton(onClick = onActionClick) {
                 Icon(
                     imageVector = actionIcon,
                     contentDescription = actionIconContentDescription,
                 )
             }
         },
         expandedHeight = expandedHeight,
         colors = colors,
         modifier = modifier.testTag("shubalTopAppBar"),
     )*/
}


@OptIn(ExperimentalMaterial3Api::class)
@Preview("Top App Bar")
@Composable
private fun ShubalCenterAlignedTopAppBarPreview() {
    ShubalTheme {
        ShubalCenterAlignedTopAppBar(
            titleRes = android.R.string.untitled,
            navigationIcon = ShubalIcons.ArrowBack,
            navigationIconContentDescription = "Navigation icon",
            actionIcon = ShubalIcons.Search,
            actionIconContentDescription = "Action icon",
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview("Top App Bar")
@Composable
private fun ShubalTopAppBarPreview() {
    ShubalTheme {
        ShubalTopAppBar(
            titleRes = android.R.string.untitled,
            navigationIcon = ShubalIcons.ArrowBack,
            navigationIconContentDescription = "Navigation icon",
            actionIcon = ShubalIcons.Search,
            actionIconContentDescription = "Action icon",
        )
    }
}


@OptIn(ExperimentalMaterial3Api::class)
object TopAppBarDefaults {
    val centerAlignedTopAppBarColors = TopAppBarColors(
        containerColor = Background,
        scrolledContainerColor = Background,
        navigationIconContentColor = Primary400,
        titleContentColor = White,
        actionIconContentColor = Primary400
    )

    val topAppBarExpandedHeight: Dp = 64.dp
}
