package io.github.atmaramnaik.kosel

import io.github.atmaramnaik.kosel.element.Locator
import io.github.atmaramnaik.kosel.element.Object

class SelectingPerformElementWithinObject<T: Object>(val selectingPerform: SelectingPerform, val obj: T) {

    infix fun element(memberSelector:T.()-> Locator): SelectingPerformObjectLocatedBy<T> {
        return SelectingPerformObjectLocatedBy(this, memberSelector);
    }
}