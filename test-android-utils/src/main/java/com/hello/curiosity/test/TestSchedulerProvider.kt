package com.hello.curiosity.test

import com.hello.curiosity.data.threading.SchedulerProvider
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers

class TestSchedulerProvider(
    private val provider: SchedulerProvider = module(Schedulers.trampoline())
) : SchedulerProvider {

    override val io: Scheduler
        get() = provider.io

    override val main: Scheduler
        get() = provider.main

    override val compute: Scheduler
        get() = provider.compute

    companion object {

        /**
         * Test scheduler provider which uses the same scheduler for all cases
         * @param scheduler the scheduler to return for all requested schedulers
         * @return
         */
        fun module(scheduler: Scheduler): SchedulerProvider {
            return TestSchedulerProvider(
                object : SchedulerProvider {
                    override val io: Scheduler
                        get() = scheduler

                    override val main: Scheduler
                        get() = scheduler

                    override val compute: Scheduler
                        get() = scheduler
                }
            )
        }
    }
}
