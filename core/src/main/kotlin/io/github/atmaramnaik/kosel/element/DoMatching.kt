package io.github.atmaramnaik.kosel.element

import org.openqa.selenium.WebElement

interface DoMatching {
    infix fun withExactText(text:String){
        doThis {
            it.text==text
        }
    }
    infix fun matching(block:(WebElement)->Boolean){
        doThis(block)
    }
    fun doThis(matcher:(WebElement)->Boolean);
}