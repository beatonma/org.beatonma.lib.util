package org.beatonma.lib.util

import android.os.Build

object Sdk {

    val isOreo: Boolean
        get() = sdkAtLeast(Build.VERSION_CODES.O)

    val isNougat: Boolean
        get() = sdkAtLeast(Build.VERSION_CODES.N)

    val isMarshmallow: Boolean
        get() = sdkAtLeast(Build.VERSION_CODES.M)

    val isLollipop: Boolean
        get() = sdkAtLeast(Build.VERSION_CODES.LOLLIPOP)

    val isKitkat: Boolean
        get() = sdkAtLeast(Build.VERSION_CODES.KITKAT)

    private fun sdkAtLeast(sdkLevel: Int): Boolean {
        return Build.VERSION.SDK_INT >= sdkLevel
    }
}
