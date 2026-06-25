package com.jsrvc.utils

import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonBuilder


/**
 *  This class converts json object to string and vise-versa
 */
object JsonParser {
	//------------------ Local Assets ------------------//
	
	const val SCREEN_CACHE_FILE = "screen_spec_cache.json"
	
	val json = Json {
//		JsonBuilder.ignoreUnknownKeys = true
//		JsonBuilder.encodeDefaults = true
//		JsonBuilder.isLenient = true
	}
	
	/**
	 * Safe encode - never throws
	 */
	inline fun <reified T> encode(value: T): String {
		return try {
			json.encodeToString(value)
		} catch (e: Exception) {
			//Timber.e(e, "JSON encode failed for ${T::class.java}")
			"{}" // safe fallback
		}
	}
	
	/**
	 * Safe decode - never throws
	 */
	inline fun <reified T> decode(value: String): T {
		return try {
			json.decodeFromString<T>(value)
		} catch (e: Exception) {
			//Timber.e(e, "JSON decode failed for ${T::class.java}: $value")
			throw JsonParsingException("Failed to decode ${T::class.java}", e)
		}
	}
	
	/**
	 * Fully safe decode (recommended for cache/data layer)
	 */
	inline fun <reified T> safeDecodeResultWrapper(value: String?): T? {
		return try {
			value?.let { decodeResult<T>(value).getOrNull() }
		} catch (e: Exception) {
			//Timber.e(e, "Safe decode failed for ${T::class.java}: $value")
			null
		}
	}
	
	inline fun <reified T> decodeResult(jdata: String): Result<T> {
		return runCatching {
			Json.decodeFromString<T>(jdata)
		}
	}
}

/**
 * Custom exception for controlled handling
 */
class JsonParsingException(message: String, cause: Throwable? = null) :
	RuntimeException(message, cause)


