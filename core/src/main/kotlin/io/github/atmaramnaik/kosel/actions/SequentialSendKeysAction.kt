package io.github.atmaramnaik.kosel.actions

import io.github.atmaramnaik.kosel.*
import io.github.atmaramnaik.kosel.element.Locator
import org.openqa.selenium.WebElement

class SequentialSendKeysAction(override val app: App, val values:List<String>):ElementsAction{
    var index:Int = 0
    override var currentActionIndex: Int
        get() = index
        set(value) {index=value}

    infix fun within(element: Locator){
        return this.actInContext(element.findAll())
    }

    override fun act(webElement: WebElement) {
        webElement.sendKeys(values[currentActionIndex])
    }

//    infix fun bySelecting(selector: Selector): SelectingPerform {
//        return SelectingPerform(this,selector)
//    }
}