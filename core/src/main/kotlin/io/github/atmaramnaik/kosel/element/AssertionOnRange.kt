package io.github.atmaramnaik.kosel.element

import org.openqa.selenium.WebElement

class AssertionOnRange<T>(val ea: Assertion, val aggregate: AssertionAggregate, val propertySelector:(WebElement)->T){
    infix fun elementFrom(locator: Locator): AssertionOnRangeMatcher<T> {
        return AssertionOnRangeMatcher(this, locator)
    }
}