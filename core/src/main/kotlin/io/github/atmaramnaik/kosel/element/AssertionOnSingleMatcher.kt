package io.github.atmaramnaik.kosel.element

import org.junit.jupiter.api.Assertions
import org.openqa.selenium.WebElement

class AssertionOnSingleMatcher<T>(val assertion: Assertion,val propertySelector:(WebElement)->T, val locator: Locator){
    infix fun isExactlySameAs(value:T){
        Assertions.assertEquals(value, propertySelector(locator.findOne(assertion.app.wait)))
    }
}