package io.github.atmaramnaik.kosel

import io.github.atmaramnaik.kosel.actions.ElementAction
import io.github.atmaramnaik.kosel.actions.ElementsAction
import io.github.atmaramnaik.kosel.element.Locator
import io.github.atmaramnaik.kosel.element.Object

class SelectingPerform(val action: ElementAction, val selector: Selector){
    infix fun matchingElementFrom(locator: Locator): SelectingPerformElementLocatedBy {
        return SelectingPerformElementLocatedBy(this, locator)
    }

    infix fun <T:Object> matchingElementFrom(obj: T): SelectingPerformElementWithinObject<T> {
        return SelectingPerformElementWithinObject(this, obj)
    }
}