@file:JvmName("View")
package org.beatonma.lib.util.kotlin.extensions

import android.content.Context
import android.graphics.Point
import android.graphics.Rect
import android.graphics.RectF
import android.text.TextUtils
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.TextView


val View.ratio: Float
    get() = width.toFloat() / height.toFloat()
val View.widthF: Float
    get() = width.toFloat()
val View.heightF: Float
    get() = height.toFloat()


fun View.center(outPoint: Point? = null): Point {
    return (outPoint ?: Point()).apply {
        x = width / 2
        y = height / 2
    }
}


fun View.bounds(outRect: Rect = Rect()): Rect {
    outRect.set(left, top, right, bottom)
    return outRect
}

fun View.boundsF(outRect: RectF = RectF()): RectF {
    outRect.set(left.toFloat(), top.toFloat(), right.toFloat(), bottom.toFloat())
    return outRect
}


/**
 * Set visible only if this view has text
 */
fun TextView.hideIfEmpty() {
    visibility = if (TextUtils.isEmpty(text)) View.GONE else View.VISIBLE
}

fun EditText.focus() {
    isFocusableInTouchMode = true
    requestFocus()
    setSelection(text.toString().length)
    val inputManager = context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    inputManager.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0)
}