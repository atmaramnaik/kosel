package io.github.atmaramnaik.kosel

import org.openqa.selenium.SearchContext

interface Context{
    val app: App
    val searchContext: SearchContext?
}