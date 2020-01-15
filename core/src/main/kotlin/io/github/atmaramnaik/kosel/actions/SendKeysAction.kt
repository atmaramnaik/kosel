package io.github.atmaramnaik.kosel.actions

import io.github.atmaramnaik.kosel.*
import io.github.atmaramnaik.kosel.element.Locator
import org.openqa.selenium.WebElement

class SendKeysAction(override val app: App, val value:String):ElementAction{
    infix fun within(element: Locator){
        return this.actInContext(element.findOne(app.wait))
    }

    override fun act(webElement: WebElement) {
        webElement.sendKeys(value)
    }

    infix fun bySelecting(selector: Selector): SelectingPerform {
        return SelectingPerform(this,selector)
    }
}