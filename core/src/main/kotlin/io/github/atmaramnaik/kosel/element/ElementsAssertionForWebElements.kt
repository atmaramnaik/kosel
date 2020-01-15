package io.github.atmaramnaik.kosel.element

import org.openqa.selenium.WebElement

interface ElementsAssertionForWebElements{
    val elements:List<WebElement>
    infix fun match(test:(List<WebElement>)->Unit){
        test(elements)
    }
    infix fun withTexts(values:List<String>){
        assert(elements.size == values.size){
            elements.forEach {
                assert(values.contains(it.text),{"expected ${values} to contain ${it.text}"})
            }
        }
    }
}