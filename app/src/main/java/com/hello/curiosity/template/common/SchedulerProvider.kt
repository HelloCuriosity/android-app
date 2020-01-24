package com.hello.curiosity.template.common

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

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
