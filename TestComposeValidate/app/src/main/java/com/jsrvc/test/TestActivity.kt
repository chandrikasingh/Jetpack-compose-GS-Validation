package com.jsrvc.test

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.tv.material3.Button
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.Text
import com.jsrvc.ui.theme.JServiceBindingTheme
import kotlinx.coroutines.launch
import android.provider.Settings
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.net.toUri


class TestActivity : ComponentActivity() {
	val TAG: String = "TestValidator"
	
	private val EP_GLOBAL_KEY = "EVENT_LOAD_INFO"
	
	private fun writeEventProgress(event: Int) {
		runCatching {
			Settings.Global.putInt(
				contentResolver,
				EP_GLOBAL_KEY,
				event
			)
		}.onSuccess {
			Log.d(TAG, "TestValidator: Event written successfully: $event")
		}.onFailure {
			Log.e(TAG, "TestValidator: Failed to write event", it)
		}
	}

	private val requestedSpecialApiResult = registerForActivityResult(
		ActivityResultContracts.StartActivityForResult()) { result ->

		when (result.resultCode) {
			RESULT_OK -> {
				Log.e(TAG, "TestValidator: ********** WRITE_SETTINGS Not GRANTED ********")
			}
			else ->{
				Log.e(TAG, "TestValidator:  WRITE_SETTINGS NOT GRANTED")
			}
		}
	}
	
	private fun openWriteSettings(context: Context) {
		val localIntent = Intent(Settings.ACTION_MANAGE_WRITE_SETTINGS).apply {
				data = "package:${context.packageName}".toUri()
			}
			if (localIntent.resolveActivity(context.packageManager) != null) {
				requestedSpecialApiResult.launch(localIntent)
			} else {
				Log.e("TAG", "Query to WRITE_SETTINGS not supported")
			}
	}

	@OptIn(ExperimentalTvMaterial3Api::class)
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		
		setContent {
			
			if (Settings.System.canWrite(this)) {
				Log.d(TAG, "TestValidator: WRITE_SETTINGS GRANTED")
			} else {
				//use special APIs to grant the permission
				openWriteSettings(this)
			}
			
			JServiceBindingTheme {
				val coroutineScope = rememberCoroutineScope()
				
				Surface(
					modifier = Modifier.fillMaxSize(),
					color = Color.Transparent
				){
					OBMenuButton{ index ->
						Log.d(TAG, "TestValidator: index = $index")
						coroutineScope.launch {
							writeEventProgress(index)
						}
					}
				}
			}
		}
	}

	
}

@Composable
fun OBMenuButton(
	topPadding: Dp = 0.dp,
	onBrowseClick: (id: Int) -> Unit
) {
	val nextPadding = topPadding + 10.dp
	val commands = listOf(
		/**** Execution Commands ****/
		"HomeCommand-1",
		"HomeCommand-2",
		"HomeCommand-3",
		"CompleteCommand-4",
	)
	
	
	LazyColumn(
		modifier = Modifier.fillMaxSize(),
		horizontalAlignment = Alignment.CenterHorizontally,
		verticalArrangement = Arrangement.Center
	) {
		item {
			Spacer(modifier = Modifier.height(10.dp))
			Text("Lets start with the\n demo now")
			Spacer(modifier = Modifier.height(10.dp))
		}
		
		itemsIndexed(commands) { index, cmdText ->
			Button(
				onClick = { onBrowseClick(index + 1) },
				modifier = Modifier.padding(
					top = if (index == 3) nextPadding else 10.dp
				)
			) {
				Text(cmdText)
			}
		}
	}
	
}




















