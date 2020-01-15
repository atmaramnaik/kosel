package io.github.atmaramnaik.kosel.element

class AssertionOnRangeMatcher<T>(val eaor: AssertionOnRange<T>, val locator: Locator){
    infix fun isExactlySameAs(value:T){
        assert(eaor.aggregate.combine(
                locator.findAll().map {
                    value==eaor.propertySelector(it)
                }
        ))
    }
}