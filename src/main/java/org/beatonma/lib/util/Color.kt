package org.beatonma.lib.util

import android.content.Context
import android.graphics.Color.blue
import android.graphics.Color.green
import android.graphics.Color.red
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.annotation.FloatRange
import androidx.annotation.IntRange
import org.beatonma.lib.util.kotlin.extensions.colorCompat
import android.graphics.Color as PlatformColor

@ColorInt
fun removeAlpha(color: Int): Int {
    return PlatformColor.rgb(red(color), green(color), blue(color))
}

@ColorInt
fun setAlpha(color: Int, @IntRange(from = 0, to = 255) alpha: Int): Int {
    return PlatformColor.argb(alpha, red(color), green(color), blue(color))
}

@ColorInt
fun setAlpha(color: Int, @FloatRange(from = 0.0, to = 1.0) alpha: Float): Int {
    return PlatformColor.argb((alpha * 255f).toInt(), red(color), green(color), blue(color))
}


fun toHex(color: Int): String {
    return Integer.toHexString(color)
}

fun toHsv(color: Int): FloatArray {
    val hsv = FloatArray(3)
    PlatformColor.colorToHSV(color, hsv)
    return hsv
}

fun toHex(colors: IntArray): String {
    val b = StringBuilder()
    for (c in colors) {
        b.append("#")
                .append(Integer.toHexString(c))
                .append(',')
    }
    return b.toString()
}

fun toHsv(@IntRange(from = 0, to = 255) red: Int,
          @IntRange(from = 0, to = 255) green: Int,
          @IntRange(from = 0, to = 255) blue: Int): FloatArray {
    return toHsv(PlatformColor.rgb(red, green, blue))
}

fun toRgb(@ColorInt color: Int): IntArray {
    return intArrayOf(red(color), green(color), blue(color))
}

@ColorInt
fun lighten(color: Int,
            @FloatRange(from = 0.0, to = 1.0) amount: Float): Int {
    val hsv = toHsv(color)
    hsv[1] = Math.max(0f, Math.min(1f, hsv[1] - amount))    // saturation
    hsv[2] = Math.max(0f, Math.min(1f, hsv[2] + amount))    // brightness
    return PlatformColor.HSVToColor(hsv)
}

@ColorInt
fun darken(color: Int,
           @FloatRange(from = 0.0, to = 1.0) amount: Float): Int {
    val hsv = toHsv(color)
    hsv[1] = Math.max(0f, Math.min(1f, hsv[1] + amount))    // saturation
    hsv[2] = Math.max(0f, Math.min(1f, hsv[2] - amount))   // brightness
    return PlatformColor.HSVToColor(hsv)
}

/**
 * Calculate perceived luminance
 */
fun luminance(@ColorInt color: Int): Double {
    return 1 - (0.299 * red(color)
            + 0.587 * green(color)
            + 0.114 * blue(color)
            ) / 255.0
}

/**
 * Return a suitably contrasting text color for use on backgroundColor
 */
fun textColorFor(context: Context,
                 @ColorInt backgroundColor: Int? = null,
                 @ColorRes backgroundResId: Int? = null,
                 @ColorRes darkTextResId: Int,
                 @ColorRes lightTextResId: Int): Int {

    val color = when {
        backgroundColor != null -> backgroundColor
        backgroundResId != null -> context.colorCompat(backgroundResId)
        else -> throw IllegalArgumentException()
    }

    val luminance = luminance(color)

    return context.colorCompat(if (luminance < 0.5) darkTextResId else lightTextResId)
}