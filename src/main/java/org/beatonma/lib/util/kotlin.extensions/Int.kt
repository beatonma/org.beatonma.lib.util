@file:JvmName("Int")
package org.beatonma.lib.util.kotlin.extensions

/**
 * Return the result of applying binary or to the given flags
 */
fun combineFlags(vararg flags: Int): Int {
    var outFlag = 0
    flags.forEach { outFlag = outFlag or it }
    return outFlag
}

/**
 * Returns true if applying bitwise AND to the receiver and the flag yields the flag value.
 * The receiver Int is created by applying bitwise OR to zero or more binary flags.
 *
 * If no flags are set, the receiver Int should be equal to zero.
 */
fun Int.hasFlag(flag: Int): Boolean {
    return this and flag == flag
}

/**
 * Return true if the receiver contains all of the given flags
 */
fun Int.hasAllFlags(vararg flags: Int): Boolean {
    flags.forEach {flag ->
        if (this and flag != flag) return false // Return false if any flag fails
    }
    return true
}

/**
 * Return true if the receiver contains at least one of the given flags
 */
fun Int.hasAnyFlag(vararg flags: Int): Boolean {
    flags.forEach { flag ->
        if (this and flag == flag) return true
    }
    return false
}

/**
 * Return true if the receiver can be constructed entirely from the given flags
 * i.e. The receiver contains all of, and only, the given flags
 */
fun Int.hasOnlyFlags(vararg flags: Int): Boolean {
    return this == combineFlags(*flags)
}