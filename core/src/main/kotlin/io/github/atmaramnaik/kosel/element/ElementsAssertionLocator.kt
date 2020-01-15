package io.github.atmaramnaik.kosel.element

import org.openqa.selenium.WebElement

class ElementsAssertionLocator(val assertion: Assertion, val locator: Locator): ElementsAssertionForWebElements {
    override val elements: List<WebElement>
        get() = locator.findAll(assertion.app.wait)

}