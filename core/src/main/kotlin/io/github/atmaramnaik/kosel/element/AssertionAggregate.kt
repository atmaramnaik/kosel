package io.github.atmaramnaik.kosel.element

interface AssertionAggregate{
    fun combine(assertionResults:List<Boolean>):Boolean;
}