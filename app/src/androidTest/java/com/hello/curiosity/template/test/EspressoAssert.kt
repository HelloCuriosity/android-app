package com.hello.curiosity.template.test

import androidx.annotation.IdRes
import androidx.annotation.StringRes
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed

class EspressoAssert {
    companion object {
        fun assertView(@IdRes viewId: Int): ViewInteraction =
            onView(withId(viewId))
    }
}

fun ViewInteraction.isVisible(): ViewInteraction = apply {
    check(matches(isDisplayed()))
}

fun ViewInteraction.withText(@StringRes expected: Int): ViewInteraction = apply {
    check(matches(ViewMatchers.withText(expected)))
}

fun ViewInteraction.withText(expected: String): ViewInteraction = apply {
    check(matches(ViewMatchers.withText(expected)))
}