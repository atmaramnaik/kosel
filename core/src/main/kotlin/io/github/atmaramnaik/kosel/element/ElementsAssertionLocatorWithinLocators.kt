package io.github.atmaramnaik.kosel.element

import org.openqa.selenium.WebElement

class ElementsAssertionLocatorWithinLocators<T: Object>(val assertion: ObjectsAssertion<T>, val outer: Locator, val inner: Locator): ElementsAssertionForWebElements {
    override val elements: List<WebElement>
        get() = outer.findAll(assertion.a.app.wait).map { inner.findOne() }

}