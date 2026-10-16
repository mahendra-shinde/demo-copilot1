package com.example.expenses

import com.example.expenses.ui.parseAmount
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

class ValidationTest {
    @Test fun parsesPositive() = assertEquals(12.5, parseAmount(" 12.5 ")!!, 0.0)
    @Test fun rejectsInvalid() {
        assertNull(parseAmount("abc"))
        assertNull(parseAmount("0"))
        assertNull(parseAmount("-3"))
        assertNull(parseAmount("NaN"))
    }
}
