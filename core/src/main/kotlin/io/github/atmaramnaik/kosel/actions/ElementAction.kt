package io.github.atmaramnaik.kosel.actions

import io.github.atmaramnaik.kosel.App
import io.github.atmaramnaik.kosel.slow
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

interface ElementAction:Action<WebElement> {
    override fun actInContext(webElement:WebElement){
        slow(app.slow){
            act(webElement);
        }
    }
    fun highLighterMethod(driver: WebDriver, element: WebElement?) {
        val js = driver as JavascriptExecutor
        js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element)
    }
}