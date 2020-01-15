package io.github.atmaramnaik.kosel

import org.openqa.selenium.NotFoundException
import org.openqa.selenium.SearchContext
import org.openqa.selenium.support.ui.FluentWait
import org.openqa.selenium.support.ui.Sleeper
import java.time.Clock
import java.time.Duration
import java.util.concurrent.TimeUnit

class SearchContextWait(sc: SearchContext, clock: Clock, sleeper: Sleeper,
                        timeOutInSeconds:Long, sleepTimeOut:Long) : FluentWait<SearchContext>(sc,clock,sleeper){
    init {
        withTimeout(Duration.ofSeconds(timeOutInSeconds))
        pollingEvery(Duration.ofMillis(sleepTimeOut))
        ignoring(NotFoundException::class.java)
    }
    constructor(sc: SearchContext, timeOutInSeconds:Long):this(sc, Clock.systemUTC()!!, Sleeper.SYSTEM_SLEEPER,timeOutInSeconds,DEFAULT_SLEEP_TIMEOUT)
    companion object{
        val DEFAULT_SLEEP_TIMEOUT = 500L
    }
}