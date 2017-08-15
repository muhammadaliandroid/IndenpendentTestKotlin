package uk.co.mali.data.util.scheduler

import io.reactivex.Scheduler

/**
 * Created by alig2 on 15/08/2017.
 */
interface IRxSchedulers {

    fun runOnBackground(): Scheduler
    fun io(): Scheduler
    fun compute(): Scheduler
    fun androidThread(): Scheduler
    fun internet(): Scheduler
}