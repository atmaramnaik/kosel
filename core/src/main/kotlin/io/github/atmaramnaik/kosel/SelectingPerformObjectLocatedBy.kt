package io.github.atmaramnaik.kosel

import io.github.atmaramnaik.kosel.element.DoMatching
import io.github.atmaramnaik.kosel.element.Locator
import io.github.atmaramnaik.kosel.element.Object
import org.openqa.selenium.WebElement

class SelectingPerformObjectLocatedBy<T: Object>(val spewo: SelectingPerformElementWithinObject<T>, val memberSelector:T.()-> Locator): DoMatching {
    override fun doThis(matcher:(WebElement)->Boolean){
        spewo.selectingPerform.selector.select(spewo.obj.locator.findAll().map { it.findElement(spewo.obj.memberSelector().by()) }.filter( matcher)).forEach {
            spewo.selectingPerform.action.actInContext(it)
        }
    }
}