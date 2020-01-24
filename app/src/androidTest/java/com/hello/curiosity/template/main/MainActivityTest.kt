package com.hello.curiosity.template.main

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.hello.curiosity.R
import com.hello.curiosity.template.test.EspressoAssert.Companion.assertView
import com.hello.curiosity.template.test.isVisible
import com.hello.curiosity.template.test.withText
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    var rule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun testActivity() {
        assertView(R.id.tv_main)
            .isVisible()
            .withText("Hello World!")
    }
}