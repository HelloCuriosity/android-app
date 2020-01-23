package com.hello.curiosity.splash

import com.hello.curiosity.common.SchedulerProvider
import com.nhaarman.mockito_kotlin.doReturn
import com.nhaarman.mockito_kotlin.reset
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.verifyNoMoreInteractions
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.TestScheduler
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import java.util.concurrent.TimeUnit

@RunWith(MockitoJUnitRunner::class)
class SplashPresenterTest {

    @Mock
    private lateinit var mockView: SplashView

    @Mock
    private lateinit var testSchedulerProvider: SchedulerProvider

    @Mock
    private lateinit var mockDisposeBag: CompositeDisposable

    private lateinit var testScheduler: TestScheduler

    @Before
    fun setup() {
        testScheduler = TestScheduler()

        whenever(testSchedulerProvider.compute) doReturn testScheduler
        whenever(testSchedulerProvider.main) doReturn testScheduler
    }

    @Test
    fun testBind() {
        val presenter = SplashPresenter(testSchedulerProvider)
        presenter.bind(mockView)

        testScheduler.advanceTimeTo(3, TimeUnit.SECONDS)

        verify(mockView).startMainActivity()

        verifyNoMoreInteractions(mockView)
    }

    @Test
    fun testUnbind() {
        val presenter = SplashPresenter(testSchedulerProvider, mockDisposeBag)
        presenter.bind(mockView)
        testScheduler.triggerActions()

        reset(mockView, mockDisposeBag)

        presenter.unbind()

        verify(mockDisposeBag).clear()

        verifyNoMoreInteractions(mockView, mockDisposeBag)
    }
}
