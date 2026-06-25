package com.jsrvc.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

object UnitConverter {
	@Composable
	fun currentDensity() = LocalDensity.current
	
	@Composable
	fun pxToDp(px: Float): Dp {
		return with(currentDensity()) { px.toDp() }
	}
	
	@Composable
	fun dpToPx(dp: Dp): Float {
		return with(currentDensity()) { dp.toPx() }
	}
	
	@Composable
	fun pxToSp(px: Float): TextUnit {
		return with(currentDensity()) { px.toSp() }
	}
	
	@Composable
	fun calculatePxToSp(px: Float, scaleFactor: Float): TextUnit {
		return (px / (scaleFactor * currentFontScale())).sp
	}
	
	
	@Composable
	fun spToPx(sp: Float): Float {
		return with(currentDensity()) { sp.sp.toPx() }
	}
	
	@Composable
	fun currentFontScale(): Float =
		currentDensity().fontScale
	
	
}