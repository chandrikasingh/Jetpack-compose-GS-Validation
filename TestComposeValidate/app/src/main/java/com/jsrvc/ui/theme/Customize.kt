package com.jsrvc.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp


@Immutable
data class CustomColors(
	val primary: Color,
	val secondary: Color,
	val tertiary: Color,
	val quaternary: Color,
	val titleColor: Color,
	val labelColor: Color,
	val background: Color,
	val pclBackground: Color,
	val pcdBackground: Color,
	val white: Color,
	val black: Color,
	val piBackground: Color,
	val pisBackground: Color,
	val unselectedLabelColor: Color
)

@Immutable
data class CustomTypography(
	val title: TextStyle,
	val bodyLarge: TextStyle,
	val titleLarge: TextStyle,
	val labelSmall: TextStyle
)

@Immutable
data class CustomElevation(
	val default: Dp,
	val pressed: Dp
)