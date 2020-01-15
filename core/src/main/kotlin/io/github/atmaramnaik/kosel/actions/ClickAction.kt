package io.github.atmaramnaik.kosel.actions

import io.github.atmaramnaik.kosel.App
import io.github.atmaramnaik.kosel.SelectingPerform
import io.github.atmaramnaik.kosel.Selector
import io.github.atmaramnaik.kosel.element.Locator
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement


class ClickAction(override val app: App):ElementAction{
    infix fun clickOn(element: Locator){
        return this.actInContext(element.findOne(app.wait))
    }
    override fun act(webElement: WebElement) {
        webElement.click()
    }
    infix fun bySelecting(selector: Selector): SelectingPerform {
        return SelectingPerform(this,selector)
    }


}