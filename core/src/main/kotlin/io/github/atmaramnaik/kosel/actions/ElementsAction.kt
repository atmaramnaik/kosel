package io.github.atmaramnaik.kosel.actions

import io.github.atmaramnaik.kosel.App
import io.github.atmaramnaik.kosel.slow
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

interface ElementsAction:Action<List<WebElement>> {
    var currentActionIndex:Int
    override fun actInContext(target:List<WebElement>){
        target.forEachIndexed { index,element ->
            currentActionIndex=index
            slow(app.slow){
                act(element)
            }
        }
    }
}