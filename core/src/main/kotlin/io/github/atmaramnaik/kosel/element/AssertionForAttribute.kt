package io.github.atmaramnaik.kosel.element

class AssertionForAttribute(val ea: Assertion, val attribute:String){
    infix fun of(locator: Locator): AssertionOnSingleMatcher<String> {
        return AssertionOnSingleMatcher(ea,{ it.getAttribute(attribute) }, locator)
    }
    infix fun of(aggregate: AssertionAggregate): AssertionOnRange<String> {
        return AssertionOnRange(this.ea, aggregate, { it.getAttribute(attribute) })
    }
}