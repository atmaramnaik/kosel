package io.github.atmaramnaik.kosel

import io.github.atmaramnaik.kosel.element.DoMatching
import io.github.atmaramnaik.kosel.element.Locator
import org.openqa.selenium.WebElement

class SelectingPerformElementLocatedBy(val selectingPerform: SelectingPerform, val locator: Locator): DoMatching {
    override fun doThis(matcher:(WebElement)->Boolean){
        selectingPerform.selector.select(locator.findAll().filter(matcher)).forEach{
            selectingPerform.action.actInContext(it)
        }
    }
}
