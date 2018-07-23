package org.beatonma.lib.util.kotlin.extensions

import android.view.Gravity
import androidx.test.filters.SmallTest
import org.beatonma.lib.testing.kotlin.extensions.assertions.assertEquals
import org.beatonma.lib.testing.kotlin.extensions.assertions.assertFalse
import org.beatonma.lib.testing.kotlin.extensions.assertions.assertTrue
import org.junit.Test

@SmallTest
class IntTest {
    @Test
    fun combineFlags_shouldReturnBinaryOrOfEveryGivenInt() {
        combineFlags(0b1, 0b10, 0b100).assertEquals(0b111)
        combineFlags(0b1, 0b100).assertEquals(0b101)
        combineFlags(0b100, 0b1000).assertEquals(0b1100)
        combineFlags(0b111).assertEquals(0b111)
    }

    @Test
    fun int_addFlag_isCorrect() {
        0b0.addFlag(0b1).assertEquals(0b1)
        0b1.addFlag(0b10).assertEquals(0b11)
    }

    @Test
    fun int_hasFlag_isCorrect() {
        0b1.hasFlag(0b10).assertFalse()
        0b1.hasFlag(0b11).assertFalse()

        0b11.hasFlag(0b10).assertTrue()
        0b11.hasFlag(0b1).assertTrue()

        val gravityFlag = Gravity.TOP or Gravity.RIGHT
        gravityFlag.hasFlag(Gravity.TOP).assertTrue()
        gravityFlag.hasFlag(Gravity.RIGHT).assertTrue()
        gravityFlag.hasFlag(Gravity.LEFT).assertFalse()
        gravityFlag.hasFlag(Gravity.BOTTOM).assertFalse()
    }

    @Test
    fun int_hasAllFlags_isCorrect() {
        0b11.hasAllFlags(0b1, 0b10).assertTrue()
        0b11.hasAllFlags(0b1).assertTrue()
        0b11.hasAllFlags(0b10).assertTrue()
        0b11.hasAllFlags(0b1, 0b100).assertFalse()

        0b111.hasAllFlags(0b1, 0b10, 0b100).assertTrue()
        0b111.hasAllFlags(0b1, 0b10, 0b100, 0b1000).assertFalse()
        0b111.hasAllFlags(0b1000).assertFalse()
    }

    @Test
    fun int_hasAnyFlag_isCorrect() {
        0b11.hasAnyFlag(0b1, 0b10).assertTrue()
        0b11.hasAnyFlag(0b1).assertTrue()
        0b11.hasAnyFlag(0b1, 0b100).assertTrue()
        0b11.hasAnyFlag(0b100).assertFalse()
    }

    @Test
    fun int_hasOnlyFlags_isCorrect() {
        0b11.hasOnlyFlags(0b1, 0b10).assertTrue()
        0b111.hasOnlyFlags(0b1, 0b10, 0b100).assertTrue()
        0b111.hasOnlyFlags(0b1, 0b100).assertFalse()
    }

    @Test
    fun int_removeFlag_isCorrect() {
        0b111.removeFlag(0b010).assertEquals(0b101)
        0b111.removeFlag(0b001).assertEquals(0b110)
        0b111.removeFlag(0b100).assertEquals(0b011)
        0b111.removeFlag(0b011).assertEquals(0b100)
        0b000.removeFlag(0b001).assertEquals(0b000)
    }

    @Test
    fun int_removeFlags_isCorrect() {
        0b111.removeFlags(0b010, 0b001).assertEquals(0b100)
    }

    @Test
    fun int_replaceFlag_isCorrect() {
        0b111.replaceFlag(0b010, 0b10000).assertEquals(0b10101)
    }
}