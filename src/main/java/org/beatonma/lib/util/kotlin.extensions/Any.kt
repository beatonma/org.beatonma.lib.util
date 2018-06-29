package org.beatonma.lib.util.kotlin.extensions

import android.util.Log

val Any?.autotag: String
    get() = this?.javaClass?.simpleName ?: "Null"

fun Any?.log(message: String?, loglevel: Char = 'd') {
    val thisStr = when(this) {
        is Collection<*> -> toPrettyString()
        is Array<*> -> toPrettyString()
        else -> toString()
    }
    val fullText = "${if (message != null) "$message: " else ""}$thisStr"
    when (loglevel) {
        'd' -> Log.d(autotag, fullText)
        'e' -> Log.e(autotag, fullText)
        'i' -> Log.i(autotag, fullText)
        'v' -> Log.v(autotag, fullText)
        'w' -> Log.w(autotag, fullText)
    }
}