package com.hello.curiosity.template.splash

import com.hello.curiosity.data.presentation.Presenter
import com.hello.curiosity.data.threading.SchedulerProvider
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.disposables.CompositeDisposable
import java.util.concurrent.TimeUnit

class SplashPresenter(
    private val scheduler: SchedulerProvider,
    private val disposeBag: CompositeDisposable = CompositeDisposable(),
    private val delay: Long = 3,
    private val timeUnit: TimeUnit = TimeUnit.SECONDS
) : Presenter<SplashView> {

    override fun bind(view: SplashView) {
        disposeBag.add(
            Completable.complete()
                .delay(delay, timeUnit, scheduler.compute)
                .observeOn(scheduler.main)
                .subscribe(view::startMainActivity, ::println)
        )
    }

    override fun unbind() {
        disposeBag.clear()
    }
}
