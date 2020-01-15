package io.github.atmaramnaik.kosel.element

import org.junit.jupiter.api.Assertions

class ObjectsAssertion<T: Object>(val a: Assertion, val obj:T){
    infix fun element(typedPropertySelector:T.()-> Locator): ElementsAssertionLocatorWithinLocators<T> {
        return ElementsAssertionLocatorWithinLocators(this, obj.locator, obj.typedPropertySelector())
    }
    infix fun shouldBe(assertion:(obj:T)->Boolean){
        Assertions.assertEquals(true, assertion(obj))
    }
}