package com.jsrvc.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


val LocalCustomColors = staticCompositionLocalOf {
	CustomColors(
		primary = Color.Unspecified,
		secondary = Color.Unspecified,
		tertiary = Color.Unspecified,
		quaternary = Color.Unspecified,
		titleColor = Color.Unspecified,
		labelColor = Color.Unspecified,
		background = Color.Unspecified,
		pclBackground = Color.Unspecified,
		pcdBackground = Color.Unspecified,
		white = Color.Unspecified,
		black = Color.Unspecified,
		piBackground = Color.Unspecified,
		pisBackground = Color.Unspecified,
		unselectedLabelColor = Color.Unspecified
	)
}

val LocalCustomElevation = staticCompositionLocalOf {
	CustomElevation(
		default = Dp.Unspecified,
		pressed = Dp.Unspecified
	)
}

object OnboardingAppTheme {
	val colors: CustomColors
		@Composable
		get() = LocalCustomColors.current
	val typography: CustomTypography
		@Composable
		get() = LocalCustomTypography.current
	val elevation: CustomElevation
		@Composable
		get() = LocalCustomElevation.current
}

/**
 *  This is theme of library
 */
@Composable
fun OnboardingAppTheme(
	isInDarkTheme: Boolean = isSystemInDarkTheme(),
	content: @Composable () -> Unit,
) {
	val colorScheme = if (isInDarkTheme) {
		CustomColors(
			primary = Purple80,
			secondary = PurpleGrey80,
			tertiary = Pink80,
			quaternary = White20,
			titleColor = White2,
			labelColor = White80,
			background = Background,
			pclBackground = PlanCardBackground,
			pcdBackground = PlanCardDarkBackground,
			white = White,
			black = Black,
			piBackground = ProgressItemIndicator,
			pisBackground = ProgressSucceedItemIndicator,
			unselectedLabelColor = ProgressItemUnSelected
		)
	} else {
		CustomColors(
			primary = Purple40,
			secondary = PurpleGrey40,
			tertiary = Pink40,
			quaternary = White20,
			titleColor = White2,
			labelColor = White80,
			background = Background,
			pclBackground = PlanCardBackground,
			pcdBackground = PlanCardDarkBackground,
			white = White,
			black = Black,
			piBackground = ProgressItemIndicator,
			pisBackground = ProgressSucceedItemIndicator,
			unselectedLabelColor = ProgressItemUnSelected
		)
	}
	
	val elevation = CustomElevation(
		default = 6.dp,
		pressed = 8.dp
	)
	
	
	CompositionLocalProvider(
		LocalCustomColors provides colorScheme,
		LocalCustomTypography provides typography,
		LocalCustomElevation provides elevation,
		content = content
	)
}

