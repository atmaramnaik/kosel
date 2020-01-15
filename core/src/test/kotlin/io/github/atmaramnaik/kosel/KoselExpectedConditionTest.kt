package io.github.atmaramnaik.kosel

import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.openqa.selenium.By
import org.openqa.selenium.SearchContext
import org.openqa.selenium.StaleElementReferenceException
import org.openqa.selenium.WebElement

internal class KoselExpectedConditionTest{
    val element:WebElement= mockk()
    @Test
    fun `elementIfVisible should return element if visible`(){
        every { element.isDisplayed }.returns(true)
        val ret=KoselExpectedCondition.elementIfVisible(element)
        assertEquals(element,ret)
    }
    @Test
    fun `elementIfVisible should return null if element not visible`(){
        every { element.isDisplayed }.returns(false)
        val ret=KoselExpectedCondition.elementIfVisible(element)
        assertEquals(null,ret)
    }

    @Test
    fun `visibilityOfElementLocated returns WebElement`(){
        val sc:SearchContext= mockk()
        every { element.isDisplayed }.returns(true)
        every { sc.findElement(any()) }.returns(element)
        val we=KoselExpectedCondition.visibilityOfElementLocated(By.cssSelector(".abc")).apply(sc)
        assertEquals(element,we)
    }
    @Test
    fun `visibilityOfElementLocated returns null when NoSuchElementExeption`(){
        val sc:SearchContext= mockk()
        val ex = mockk<org.openqa.selenium.NoSuchElementException>()
        every { sc.findElement(any()) }.throws(ex)
        val tw=assertThrows(org.openqa.selenium.NoSuchElementException::class.java){
            KoselExpectedCondition.visibilityOfElementLocated(By.cssSelector(".abc")).apply(sc)
        }
        assertEquals(ex,tw)
    }
    @Test
    fun `visibilityOfElementLocated returns null when StaleElementReferenceExeption`(){
        val sc:SearchContext= mockk()
        val ex:StaleElementReferenceException= mockk()
        every { sc.findElement(any()) }.throws(ex)
        val ret=KoselExpectedCondition.visibilityOfElementLocated(By.cssSelector(".abc")).apply(sc)
        assertEquals(null,ret)
    }
}