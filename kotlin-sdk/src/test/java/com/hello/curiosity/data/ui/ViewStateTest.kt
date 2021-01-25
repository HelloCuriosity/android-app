package com.hello.curiosity.data.ui

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

class ViewStateTest {

    data class TestObject(val value: String)

    @Test
    fun testLoaded() {
        val expected = TestObject("Testable")
        val model = ViewState.Value(expected)
        assertEquals(expected, model.value())
        assertNull(model.error())
    }

    @Test
    fun testLoading() {
        val model = ViewState.Loading<TestObject>()
        assertNull(model.value())
        assertNull(model.error())
    }

    @Test
    fun testError() {
        val error = Exception("Test exception")
        val model = ViewState.Error<TestObject>(error)
        assertNull(model.value())
        assertEquals(error, model.error())
    }

    @Test
    fun testEmpty() {
        val model = ViewState.Empty<TestObject>()
        assertNull(model.value())
        assertNull(model.error())
    }
}
