package com.jsrvc.ui.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
/**
 *  This is Typography of library
 */
val LocalCustomTypography = staticCompositionLocalOf {
	CustomTypography(
		title = TextStyle.Default,
		bodyLarge = TextStyle.Default,
		titleLarge = TextStyle.Default,
		labelSmall = TextStyle.Default
	)
}


val typography = CustomTypography(
	title = TextStyle(
		fontFamily = FontFamily.Default,
		fontWeight = FontWeight.Normal,
		lineHeight = 24.sp,
		letterSpacing = 0.5.sp
	),
	bodyLarge = TextStyle(
		fontFamily = FontFamily.Default,
		fontWeight = FontWeight.Normal,
		lineHeight = 24.sp,
		letterSpacing = 0.5.sp
	),
	titleLarge = TextStyle(
		fontFamily = FontFamily.Default,
		fontWeight = FontWeight.Medium,
		lineHeight = 57.sp,
		letterSpacing = 0.sp
	),
	labelSmall = TextStyle(
		fontFamily = FontFamily.Default,
		fontWeight = FontWeight.Normal,
		lineHeight = 24.sp,
		letterSpacing = 0.5.sp
	)
)
