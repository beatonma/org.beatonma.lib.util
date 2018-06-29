package org.beatonma.lib.util.kotlin.extensions

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.TypedValue
import android.widget.Toast
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import org.beatonma.lib.util.Sdk

/**
 * Return the pixel value of the given dp value
 */
fun Context?.dp(value: Float = 1F): Float {
    if (this == null) return 0F
    return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, value, resources.displayMetrics)
}

fun Context.toast(text: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, text, duration).show()
}

fun Context.toast(@StringRes resId: Int, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, resId, duration).show()
}

@Suppress("DEPRECATION")
fun Context?.stringCompat(@StringRes resId: Int, vararg formatArgs: Any): String {
    if (this == null) return ""

    return if (Sdk.isMarshmallow) {
        getString(resId, *formatArgs)
    } else {
        resources.getString(resId, *formatArgs)
    }
}

@Suppress("DEPRECATION")
@ColorInt
fun Context?.colorCompat(@ColorRes resId: Int): Int {
    if (this == null) return 0
    return if (Sdk.isMarshmallow) {
        getColor(resId)
    } else {
        resources.getColor(resId)
    }
}

@Suppress("DEPRECATION")
fun Context?.drawableCompat(@DrawableRes resId: Int): Drawable? {
    if (this == null) return null
    return if (Sdk.isMarshmallow) {
        getDrawable(resId)
    } else {
        resources.getDrawable(resId)
    }
}