package org.beatonma.lib.util

import android.os.Build

object Sdk {

    val isOreo: Boolean
        get() = atLeast(Build.VERSION_CODES.O)

    val isNougat: Boolean
        get() = atLeast(Build.VERSION_CODES.N)

    val isMarshmallow: Boolean
        get() = atLeast(Build.VERSION_CODES.M)

    val isLollipop: Boolean
        get() = atLeast(Build.VERSION_CODES.LOLLIPOP)

    val isKitkat: Boolean
        get() = atLeast(Build.VERSION_CODES.KITKAT)

    fun atLeast(sdkLevel: Int): Boolean {
        return Build.VERSION.SDK_INT >= sdkLevel
    }
}
