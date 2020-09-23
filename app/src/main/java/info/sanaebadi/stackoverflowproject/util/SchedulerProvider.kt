package info.sanaebadi.stackoverflowproject.util

import io.reactivex.Scheduler

interface SchedulerProvider {
    fun uiScheduler(): Scheduler
    fun ioScheduler(): Scheduler
}