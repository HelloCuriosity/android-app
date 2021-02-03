package com.hello.curiosity.data.threading

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers

interface SchedulerProvider {
    val io: Scheduler
    val main: Scheduler
    val compute: Scheduler

    companion object {
        val default: SchedulerProvider = object : SchedulerProvider {
            override val io = Schedulers.io()
            override val main = AndroidSchedulers.mainThread()
            override val compute = Schedulers.computation()
        }
    }
}
