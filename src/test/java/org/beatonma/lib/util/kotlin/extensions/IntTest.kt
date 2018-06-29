package org.beatonma.lib.util.kotlin.extensions

import android.view.Gravity
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test


class IntTest {
    @Test
    fun combineFlags_shouldReturnBinaryOrOfEveryGivenInt() {
        assertEquals(0b111, combineFlags(0b1, 0b10, 0b100))
        assertEquals(0b101, combineFlags(0b1, 0b100))
        assertEquals(0b1100, combineFlags(0b100, 0b1000))
        assertEquals(0b111, combineFlags(0b111))
    }

    @Test
    fun int_hasFlag_isCorrect() {
        assertFalse(0b1.hasFlag(0b10))
        assertFalse(0b1.hasFlag(0b11))

        assertTrue(0b11.hasFlag(0b10))
        assertTrue(0b11.hasFlag(0b1))

        val gravityFlag = Gravity.TOP or Gravity.RIGHT
        assertTrue(gravityFlag.hasFlag(Gravity.TOP))
        assertTrue(gravityFlag.hasFlag(Gravity.RIGHT))
        assertFalse(gravityFlag.hasFlag(Gravity.LEFT))
        assertFalse(gravityFlag.hasFlag(Gravity.BOTTOM))
    }

    @Test
    fun int_hasAllFlags_isCorrect() {
        assertTrue(0b11.hasAllFlags(0b1, 0b10))
        assertTrue(0b11.hasAllFlags(0b1))
        assertTrue(0b11.hasAllFlags(0b10))
        assertFalse(0b11.hasAllFlags(0b1, 0b100))

        assertTrue(0b111.hasAllFlags(0b1, 0b10, 0b100))
        assertFalse(0b111.hasAllFlags(0b1, 0b10, 0b100, 0b1000))
        assertFalse(0b111.hasAllFlags(0b1000))
    }

    @Test
    fun int_hasAnyFlag_isCorrect() {
        assertTrue(0b11.hasAnyFlag(0b1, 0b10))
        assertTrue(0b11.hasAnyFlag(0b1))
        assertTrue(0b11.hasAnyFlag(0b1, 0b100))
        assertFalse(0b11.hasAnyFlag(0b100))
    }

    @Test
    fun int_hasOnlyFlags_isCorrect() {
        assertTrue(0b11.hasOnlyFlags(0b1, 0b10))
        assertTrue(0b111.hasOnlyFlags(0b1, 0b10, 0b100))
        assertFalse(0b111.hasOnlyFlags(0b1, 0b100))
    }
}