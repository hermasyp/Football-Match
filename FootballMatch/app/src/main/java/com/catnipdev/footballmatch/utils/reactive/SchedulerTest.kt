package com.catnipdev.footballmatch.utils.reactive

import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers

/**
Written with love by Muhammad Hermas Yuda Pamungkas
Github : https://github.com/hermasyp
 **/
class SchedulerTest:SchedulerInterface{
    override fun mainThread(): Scheduler = Schedulers.trampoline()
    override fun computation(): Scheduler = Schedulers.trampoline()
    override fun trampoline(): Scheduler = Schedulers.trampoline()
    override fun newThread(): Scheduler = Schedulers.trampoline()
    override fun io(): Scheduler = Schedulers.trampoline()
}