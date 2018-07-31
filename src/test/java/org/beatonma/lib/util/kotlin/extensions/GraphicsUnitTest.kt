package org.beatonma.lib.util.kotlin.extensions

import android.graphics.Rect
import android.graphics.RectF
import org.beatonma.lib.testing.kotlin.extensions.mock
import org.beatonma.lib.testing.kotlin.extensions.whenever
import org.junit.Assert.assertEquals
import org.junit.Test
import org.mockito.Matchers.anyFloat
import org.mockito.Matchers.anyInt

class GraphicsUnitTest {
    private fun createMockRect(): Rect {
        val rect = mock<Rect>()
        whenever(rect.set(anyInt(), anyInt(), anyInt(), anyInt())).then {
            rect.left = it.getArgumentAt(0, Int::class.java) as Int
            rect.top = it.getArgumentAt(1, Int::class.java) as Int
            rect.right = it.getArgumentAt(2, Int::class.java) as Int
            rect.bottom = it.getArgumentAt(3, Int::class.java) as Int
            Unit
        }
        return rect
    }

    private fun createMockRectF(): RectF {
        val rect = mock<RectF>()
        whenever(rect.set(anyFloat(), anyFloat(), anyFloat(), anyFloat())).then {
            rect.left = it.getArgumentAt(0, Float::class.java) as Float
            rect.top = it.getArgumentAt(1, Float::class.java) as Float
            rect.right = it.getArgumentAt(2, Float::class.java) as Float
            rect.bottom = it.getArgumentAt(3, Float::class.java) as Float
            Unit
        }
        return rect
    }


    /* Rect */
    @Test
    fun testRect_update() {
        val rect = createMockRect()

        assertEquals(0, rect.left)
        assertEquals(0, rect.top)
        assertEquals(0, rect.right)
        assertEquals(0, rect.bottom)

        // Update all values
        rect.update(-10, -15, 20, 35)
        assertEquals(-10, rect.left)
        assertEquals(-15, rect.top)
        assertEquals(20, rect.right)
        assertEquals(35, rect.bottom)

        // Update only single value
        rect.update(top = 8)
        assertEquals(-10, rect.left)
        assertEquals(8, rect.top)
        assertEquals(20, rect.right)
        assertEquals(35, rect.bottom)

        // Update a different single value
        rect.update(right = 22)
        assertEquals(-10, rect.left)
        assertEquals(8, rect.top)
        assertEquals(22, rect.right)
        assertEquals(35, rect.bottom)
    }

    @Test
    fun testRect_updateBy() {
        val rect = createMockRect()

        assertEquals(0, rect.left)
        assertEquals(0, rect.top)
        assertEquals(0, rect.right)
        assertEquals(0, rect.bottom)

        // Update all values
        rect.updateBy(-10, -15, 20, 35)
        assertEquals(-10, rect.left)
        assertEquals(-15, rect.top)
        assertEquals(20, rect.right)
        assertEquals(35, rect.bottom)

        // Update only single value, ensuring other values do not change
        rect.updateBy(top = 8)
        assertEquals(-10, rect.left)
        assertEquals(-7, rect.top)
        assertEquals(20, rect.right)
        assertEquals(35, rect.bottom)

        // Update a different single value
        rect.updateBy(right = 22)
        assertEquals(-10, rect.left)
        assertEquals(-7, rect.top)
        assertEquals(42, rect.right)
        assertEquals(35, rect.bottom)

        // Update with negative value
        rect.updateBy(bottom = -12)
        assertEquals(23, rect.bottom)
    }


    /* RectF */
    @Test
    fun testRectF_update() {
        val rectF = createMockRectF()

        assertEquals(0F, rectF.left)
        assertEquals(0F, rectF.top)
        assertEquals(0F, rectF.right)
        assertEquals(0F, rectF.bottom)

        // Update all values
        rectF.update(-10F, -15F, 20F, 35F)
        assertEquals(-10F, rectF.left)
        assertEquals(-15F, rectF.top)
        assertEquals(20F, rectF.right)
        assertEquals(35F, rectF.bottom)

        // Update only single value
        rectF.update(top = 8F)
        assertEquals(-10F, rectF.left)
        assertEquals(8F, rectF.top)
        assertEquals(20F, rectF.right)
        assertEquals(35F, rectF.bottom)

        // Update a different single value
        rectF.update(right = 22F)
        assertEquals(-10F, rectF.left)
        assertEquals(8F, rectF.top)
        assertEquals(22F, rectF.right)
        assertEquals(35F, rectF.bottom)
    }

    @Test
    fun testRectF_updateBy() {
        val rectF = createMockRectF()

        assertEquals(0F, rectF.left)
        assertEquals(0F, rectF.top)
        assertEquals(0F, rectF.right)
        assertEquals(0F, rectF.bottom)

        // Update all values
        rectF.updateBy(-10F, -15F, 20F, 35F)
        assertEquals(-10F, rectF.left)
        assertEquals(-15F, rectF.top)
        assertEquals(20F, rectF.right)
        assertEquals(35F, rectF.bottom)

        // Update only single value, ensuring other values do not change
        rectF.updateBy(top = 8F)
        assertEquals(-10F, rectF.left)
        assertEquals(-7F, rectF.top)
        assertEquals(20F, rectF.right)
        assertEquals(35F, rectF.bottom)

        // Update a different single value
        rectF.updateBy(right = 22F)
        assertEquals(-10F, rectF.left)
        assertEquals(-7F, rectF.top)
        assertEquals(42F, rectF.right)
        assertEquals(35F, rectF.bottom)

        // Update with negative value
        rectF.updateBy(bottom = -12F)
        assertEquals(23F, rectF.bottom)
    }
}
