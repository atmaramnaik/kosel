package io.github.atmaramnaik.kosel.web.element.locator

import io.github.atmaramnaik.kosel.App
import io.github.atmaramnaik.kosel.element.Locator
import org.openqa.selenium.By
import org.openqa.selenium.SearchContext
import kotlin.reflect.KProperty

class CSS(override val app: App, override val searchContext: SearchContext?, override val locator: String): Locator {
    override fun by(): By {
        return By.cssSelector(locator);
    }
    operator fun getValue(thisRef: Any?,
                          property: KProperty<*>): CSS {
        return this
    }
}