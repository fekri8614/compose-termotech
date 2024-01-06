package info.fekri8614.thermocall.util

import android.util.Log
import kotlinx.coroutines.CoroutineExceptionHandler

val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
    Log.e("coroutineExceptionHandler", throwable.message ?: "null-message", throwable)
}

fun textLengthStyle(txt: String, length: Int): String {
    if (txt.length > length) return txt.substring(0, length) + "..."
    return txt
}

fun firstBigText(txt: String): String {
    return if (!txt[0].isUpperCase()) {
        txt.replaceFirstChar { it.uppercase() }
    } else {
        txt
    }
}

