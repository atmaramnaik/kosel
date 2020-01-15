package io.github.atmaramnaik.kosel.element

import io.github.atmaramnaik.kosel.App

class Assertion(val app: App){
    infix fun textOf(aggregate: AssertionAggregate): AssertionOnRange<String> {
        return AssertionOnRange(this, aggregate, { it.text })
    }
    infix fun textOf(locator: Locator): AssertionOnSingleMatcher<String> {
        return AssertionOnSingleMatcher(this,{ it.text }, locator)
    }
    infix fun attribute(attribute:String): AssertionForAttribute {
        return AssertionForAttribute(this, attribute)
    }

    infix fun elements(locator: Locator): ElementsAssertionLocator {
        return ElementsAssertionLocator(this,locator)
    }

    infix fun <T:Object> element(obj: T): ObjectAssertion<T> {
        return ObjectAssertion(this,obj)
    }

    infix fun <T:Object> elements(obj: T): ObjectsAssertion<T> {
        return ObjectsAssertion(this,obj)
    }
}

