package com.hello.curiosity.splash

import com.hello.curiosity.common.SchedulerProvider
import com.nhaarman.mockito_kotlin.doReturn
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.verifyNoMoreInteractions
import io.reactivex.schedulers.TestScheduler
import org.junit.Before
import org.junit.Test
import java.util.concurrent.TimeUnit

class SplashPresenterTest {
    private lateinit var testScheduler: TestScheduler
    private lateinit var testSchedulerProvider: SchedulerProvider

    @Before
    fun setup() {
        testScheduler = TestScheduler()
        testSchedulerProvider = mock {
            on { compute } doReturn testScheduler
            on { main } doReturn testScheduler
        }
    }

    @Test
    fun testBindView() {
        val mockView = mock<SplashView>()

        val presenter = SplashPresenter(testSchedulerProvider)
        presenter.bind(mockView)

        testScheduler.advanceTimeTo(3, TimeUnit.SECONDS)

        verify(mockView).startMainActivity()

        verifyNoMoreInteractions(mockView)
    }
}
