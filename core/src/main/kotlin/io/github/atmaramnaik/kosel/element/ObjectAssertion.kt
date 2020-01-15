package io.github.atmaramnaik.kosel.element

import org.junit.jupiter.api.Assertions

class ObjectAssertion<T: Object>(val a: Assertion, val obj:T){
    infix fun shouldNotBe(assertion:(obj:T)->Boolean){
        Assertions.assertEquals(false, assertion(obj))
    }
    infix fun shouldBe(assertion:(obj:T)->Boolean){
        Assertions.assertEquals(true, assertion(obj))
    }
}