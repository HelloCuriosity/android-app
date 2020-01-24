package com.hello.curiosity.template.splash

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
class SplashActivityTest {

    @get:Rule
    var rule = ActivityTestRule(SplashActivity::class.java)

    @Test
    fun testActivity() {
        assertView(R.id.tv_app_name)
            .isVisible()
            .withText(R.string.app_name)
    }
}
