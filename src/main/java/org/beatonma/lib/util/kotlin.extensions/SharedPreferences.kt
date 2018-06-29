@file:JvmName("SharedPreferences")
package org.beatonma.lib.util.kotlin.extensions

import android.content.SharedPreferences
import android.graphics.Rect
import android.graphics.RectF

fun SharedPreferences.getRect(baseKey: String, outRect: Rect = Rect()): Rect {
    outRect.update(
            left = getInt("${baseKey}_left", outRect.left),
            top = getInt("${baseKey}_top", outRect.top),
            right = getInt("${baseKey}_right", outRect.right),
            bottom = getInt("${baseKey}_bottom", outRect.bottom)
    )
    return outRect
}

fun SharedPreferences.Editor.putRect(baseKey: String, rect: Rect): SharedPreferences.Editor {
    putInt("${baseKey}_left", rect.left)
    putInt("${baseKey}_top", rect.top)
    putInt("${baseKey}_right", rect.right)
    putInt("${baseKey}_bottom", rect.bottom)
    return this
}


fun SharedPreferences.getRectF(baseKey: String, outRectF: RectF = RectF()): RectF {
    outRectF.update(
            left = getFloat("${baseKey}_left", outRectF.left),
            top = getFloat("${baseKey}_top", outRectF.top),
            right = getFloat("${baseKey}_right", outRectF.right),
            bottom = getFloat("${baseKey}_bottom", outRectF.bottom))
    return outRectF
}

fun SharedPreferences.Editor.putRectF(baseKey: String, rectF: RectF): SharedPreferences.Editor {
    putFloat("${baseKey}_left", rectF.left)
    putFloat("${baseKey}_top", rectF.top)
    putFloat("${baseKey}_right", rectF.right)
    putFloat("${baseKey}_bottom", rectF.bottom)
    return this
}