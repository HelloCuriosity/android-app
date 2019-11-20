package com.hello.curiosity.splash

import com.hello.curiosity.common.Presenter
import com.hello.curiosity.common.SchedulerProvider
import io.reactivex.Completable
import io.reactivex.disposables.CompositeDisposable
import java.util.concurrent.TimeUnit

class SplashPresenter(
    private val scheduler: SchedulerProvider,
    private val delay: Long = 3,
    private val timeUnit: TimeUnit = TimeUnit.SECONDS
) : Presenter<SplashView> {

    private val disposeBag = CompositeDisposable()

    override fun bind(view: SplashView) {
        disposeBag.add(
            Completable.complete()
                .delay(delay, timeUnit, scheduler.compute)
                .observeOn(scheduler.main)
                .subscribe(view::startMainActivity)
        )
    }

    override fun unbind() {
        disposeBag.clear()
    }
}