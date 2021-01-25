package com.hello.curiosity.template.splash

import com.hello.curiosity.data.threading.SchedulerProvider
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
    private lateinit var view: SplashView

    @Mock
    private lateinit var testSchedulerProvider: SchedulerProvider

    @Mock
    private lateinit var disposeBag: CompositeDisposable

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
        presenter.bind(view)

        testScheduler.advanceTimeTo(3, TimeUnit.SECONDS)

        verify(view).startMainActivity()

        verifyNoMoreInteractions(view)
    }

    @Test
    fun testUnbind() {
        val presenter = SplashPresenter(testSchedulerProvider, disposeBag)
        presenter.bind(view)
        testScheduler.triggerActions()

        reset(view, disposeBag)

        presenter.unbind()

        verify(disposeBag).clear()

        verifyNoMoreInteractions(view, disposeBag)
    }
}
