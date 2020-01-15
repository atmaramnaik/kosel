package io.github.atmaramnaik.kosel.element

import io.github.atmaramnaik.kosel.Context
import io.github.atmaramnaik.kosel.KoselExpectedCondition
import io.github.atmaramnaik.kosel.SearchContextWait
import org.openqa.selenium.By
import org.openqa.selenium.TimeoutException
import org.openqa.selenium.WebElement

interface Locator: Context {
    val locator:String
    fun by(): By
    fun findOne(wait:Long=5L): WebElement {
        val wait= SearchContextWait(this.searchContext!!, wait)
        wait.until(KoselExpectedCondition.visibilityOfElementLocated(by()))
        return this.searchContext!!.findElement(this.by())
    }
    fun findAll(wait:Long=3L): List<WebElement> {
        val wait= SearchContextWait(this.searchContext!!, wait)
        try{
            wait.until(KoselExpectedCondition.visibilityOfElementLocated(by()))
        } catch (tw:TimeoutException){

        }
        return this.searchContext!!.findElements(this.by())
    }
}