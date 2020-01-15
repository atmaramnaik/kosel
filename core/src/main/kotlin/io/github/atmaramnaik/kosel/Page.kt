package io.github.atmaramnaik.kosel

import io.github.atmaramnaik.kosel.element.*
import org.openqa.selenium.*
interface Page:Context {
    override val searchContext: SearchContext
        get() = app.driver
    val anyOne: AssertionAggregate
    get() = object : AssertionAggregate {
        override fun combine(assertionResults:List<Boolean>):Boolean{
            if(assertionResults.contains(true))
                return true
            return false;
        }

    }
    val perform:Perform
            get() = Perform(this.app)

    val nothing:(WebElement)->Boolean
    get() = {true}
    val assertThat: Assertion
    get() = Assertion(this.app)
    val present: (Object) -> Boolean
    get() = {
        try {
            it.locator.findOne(this.app.wait)
            true
        } catch (tw:Throwable){
            false
        }
    }
    val visible: (Object) -> Boolean
        get() = {
            try {
                it.locator.findOne(this.app.wait).isDisplayed
            } catch (tw:Throwable){
                false
            }
        }
    interface SelectorAndAssertionAggregate:Selector, AssertionAggregate
    val first:SelectorAndAssertionAggregate
        get() = object:SelectorAndAssertionAggregate{
            override fun select(from: List<WebElement>): List<WebElement> {
                return listOf(from.first())
            }

            override fun combine(assertionResults: List<Boolean>): Boolean {
                return assertionResults.first()
            }
        }

    val last:SelectorAndAssertionAggregate
        get() = object:SelectorAndAssertionAggregate{
            override fun select(from: List<WebElement>): List<WebElement> {
                return listOf(from.last())
            }

            override fun combine(assertionResults: List<Boolean>): Boolean {
                return assertionResults.last()
            }

        }

    val all:SelectorAndAssertionAggregate
        get() = object:SelectorAndAssertionAggregate{
            override fun select(from: List<WebElement>): List<WebElement> {
                return from
            }

            override fun combine(assertionResults: List<Boolean>): Boolean {
                return assertionResults.reduce({a,b->a && b})
            }
        }
}
