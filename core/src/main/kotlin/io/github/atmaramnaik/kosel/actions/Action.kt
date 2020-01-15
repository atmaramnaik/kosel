package io.github.atmaramnaik.kosel.actions

import io.github.atmaramnaik.kosel.App
import org.openqa.selenium.WebElement

interface Action<T> {
    val app: App
    fun act(webElement: WebElement)
    fun actInContext(target: T);
}