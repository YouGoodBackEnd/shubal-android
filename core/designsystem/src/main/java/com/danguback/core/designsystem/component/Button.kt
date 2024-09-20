package com.danguback.core.designsystem.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.danguback.core.designsystem.icon.ShubalIcons
import com.danguback.core.designsystem.theme.Background
import com.danguback.core.designsystem.theme.Stroke
import com.danguback.core.designsystem.theme.ShubalTheme
import com.danguback.core.designsystem.theme.White

@Composable
fun ShubalButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    content: @Composable RowScope.() -> Unit,
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        colors = ButtonDefaults.buttonColors(
            containerColor = Background,
            contentColor = White,
        ),
        contentPadding = contentPadding,
        content = content,
    )
}

@Composable
fun ShubalButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    text: @Composable () -> Unit,
    leadingIcon: @Composable (() -> Unit)? = null,
) {
    ShubalButton(
        onClick = onClick,
        modifier = modifier.fillMaxWidth(),
        enabled = enabled,
        contentPadding = if (leadingIcon != null) {
            ShubalButtonDefaults.ButtonWithIconContentPadding
        } else {
            ShubalButtonDefaults.ContentPadding
        },
    ) {
        ShubalButtonContent(
            text = text,
            leadingIcon = leadingIcon,
        )
    }
}

@Composable
fun ShubalOutlinedButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    content: @Composable RowScope.() -> Unit,
) {
    OutlinedButton(
        onClick = onClick,
        modifier = modifier.fillMaxWidth(),
        enabled = enabled,
        colors = ButtonDefaults.outlinedButtonColors(
            contentColor = White,
            containerColor = Background
        ),
        border = BorderStroke(
            width = ShubalButtonDefaults.OutlinedButtonBorderWidth,
            color = if (enabled) {
                Stroke
            } else {
                MaterialTheme.colorScheme.onSurface.copy(
                    alpha = ShubalButtonDefaults.DISABLED_OUTLINED_BUTTON_BORDER_ALPHA,
                )
            },
        ),
        contentPadding = contentPadding,
        content = content,
    )
}

@Composable
fun ShubalOutlinedButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    text: @Composable () -> Unit,
    leadingIcon: @Composable (() -> Unit)? = null,
) {
    ShubalOutlinedButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        contentPadding = if (leadingIcon != null) {
            ShubalButtonDefaults.ButtonWithIconContentPadding
        } else {
            ShubalButtonDefaults.ContentPadding
        },
    ) {
        ShubalButtonContent(text = text, leadingIcon = leadingIcon)
    }
}

@Composable
private fun ShubalButtonContent(
    text: @Composable () -> Unit,
    leadingIcon: @Composable (() -> Unit)? = null,
) {
    if (leadingIcon != null) {
        Box(Modifier.sizeIn(maxHeight = ButtonDefaults.IconSize)) {
            leadingIcon()
        }
    }
    Box(
        Modifier
            .padding(
                start = if (leadingIcon != null) {
                    ButtonDefaults.IconSpacing
                } else {
                    0.dp
                },
            ),
    ) {
        text()
    }
}

@Preview
@Composable
fun ShubalButtonPreview() {
    ShubalTheme {
        ShubalButton(
            onClick = { },
            text = { Text(text = "신발정보는 슈발") }
        )
    }
}

@Preview
@Composable
fun ShubalIconButtonPreview() {
    ShubalTheme {
        ShubalButton(
            onClick = { },
            leadingIcon = { Icon(imageVector = ShubalIcons.Search, contentDescription = null) },
            text = { Text(text = "신발정보는 슈발") }
        )
    }
}

@Preview
@Composable
fun ShubalOutlinedButtonPreview() {
    ShubalTheme {
        ShubalOutlinedButton(
            onClick = { },
            text = { Text(text = "신발정보는 슈발") }
        )
    }
}

@Preview
@Composable
fun ShubalOutlinedIconButtonPreview() {
    ShubalTheme {
        ShubalOutlinedButton(
            onClick = { },
            leadingIcon = { Icon(imageVector = ShubalIcons.Search, contentDescription = null) },
            text = { Text(text = "신발정보는 슈발") }
        )
    }
}

object ShubalButtonDefaults {
    // TODO: File bug
    // OutlinedButton border color doesn't respect disabled state by default
    const val DISABLED_OUTLINED_BUTTON_BORDER_ALPHA = 0.12f

    // TODO: File bug
    // OutlinedButton default border width isn't exposed via ButtonDefaults
    val OutlinedButtonBorderWidth = 1.dp

    private val ButtonVerticalPadding = 10.dp
    private val ButtonHorizontalPadding = 24.dp
    val ContentPadding =
        PaddingValues(
            start = ButtonHorizontalPadding,
            top = ButtonVerticalPadding,
            bottom = ButtonVerticalPadding,
            end = ButtonHorizontalPadding
        )

    private val ButtonWithIconHorizontalStartPadding = 16.dp
    val ButtonWithIconContentPadding =
        PaddingValues(
            start = ButtonWithIconHorizontalStartPadding,
            top = ButtonVerticalPadding,
            bottom = ButtonVerticalPadding ,
            end = ButtonHorizontalPadding
        )
}