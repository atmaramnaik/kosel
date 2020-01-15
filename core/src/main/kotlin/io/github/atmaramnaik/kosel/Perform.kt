package io.github.atmaramnaik.kosel

import io.github.atmaramnaik.kosel.actions.ClickAction
import io.github.atmaramnaik.kosel.actions.SendKeysAction
import io.github.atmaramnaik.kosel.actions.SequentialSendKeysAction
import io.github.atmaramnaik.kosel.element.Locator

class Perform(val app: App){
    infix fun typing(value:String): SendKeysAction {
        return SendKeysAction(app, value)
    }
    infix fun sequentialTyping(values:List<String>): SequentialSendKeysAction {
        return SequentialSendKeysAction(app, values)
    }
    infix fun clickOn(element: Locator){
        ClickAction(app) clickOn element
    }
    infix fun clickOn(selector:Selector): SelectingPerform {
        return SelectingPerform(ClickAction(app),selector)
    }
}

