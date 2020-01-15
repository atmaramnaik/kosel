package io.github.atmaramnaik.kosel

import org.openqa.selenium.WebElement

interface Selector{
    fun select(from:List<WebElement>):List<WebElement>
}