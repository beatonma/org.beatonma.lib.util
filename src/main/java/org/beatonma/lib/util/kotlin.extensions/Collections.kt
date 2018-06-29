package org.beatonma.lib.util.kotlin.extensions

/**
 * Replace the contents of this list with the contents of the other
 */
fun <T> MutableList<T>.clone(source: MutableList<T>?) {
    clear()
    if (source != null) addAll(source)
}

/**
 * Create a new MutableList with the same contents as this
 */
fun <T> MutableList<T>?.clone(): MutableList<T> {
    val newList = mutableListOf<T>()
    newList.clone(this)
    return newList
}


fun Collection<*>?.toPrettyString(): String {
    if (this == null) return "null"

    val builder = StringBuilder()
            .append(this.javaClass.simpleName)
            .append("[")
            .append(size)
            .append("]: {")
    var i = 0
    for (child in this) {
        if (i != 0) {
            builder.append(", ")
        }
        builder.append(child?.toString() ?: "null")

        i = 1
    }
    builder.append("}")

    return builder.toString()
}

fun Array<*>?.toPrettyString(): String {
    if (this == null) return "null"

    val builder = StringBuilder()
            .append(this.javaClass.simpleName)
            .append("[")
            .append(size)
            .append("]: {")
    var i = 0
    for (child in this) {
        if (i != 0) {
            builder.append(", ")
        }
        builder.append(child?.toString() ?: "null")

        i = 1
    }
    builder.append("}")

    return builder.toString()
}