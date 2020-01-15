package io.github.atmaramnaik.kosel

import org.openqa.selenium.WebDriver

interface App {
    val driver: WebDriver
    val wait:Long
        get() = 5L
    val slow:Long
        get() = 10L
}