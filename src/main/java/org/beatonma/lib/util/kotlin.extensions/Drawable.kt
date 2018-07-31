@file:JvmName("Drawable")

package org.beatonma.lib.util.kotlin.extensions

import android.graphics.drawable.Drawable
import androidx.annotation.ColorInt
import org.beatonma.lib.util.Sdk

fun Drawable.tinted(@ColorInt color: Int): Drawable {
    if (!Sdk.isLollipop) return this
    return mutate().apply {
        setTint(color)
    }
}
