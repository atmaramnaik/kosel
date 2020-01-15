package io.github.atmaramnaik.kosel.web.element

import io.github.atmaramnaik.kosel.App
import io.github.atmaramnaik.kosel.element.Locator
import io.github.atmaramnaik.kosel.element.Object
import io.github.atmaramnaik.kosel.web.element.locator.CSS

open class CustomObject(override val app:App,override val locator: Locator): Object {
    val webElement by lazy {
        this.locator.findOne(app.wait)
    }
    infix fun css(locator: String): Lazy<CSS> {
        return lazy {CSS(this.locator.app, webElement, locator)}
    }

//    fun <T: CustomObject>co(locator: Locator, factory:(locator: Locator)->T):Lazy<T>{
//        return lazy { factory(locator) }
//    }
    fun <T: CustomObject>co(locator: Lazy<Locator>, factory:(app:App,locator: Locator)->T):Lazy<T>{
        return lazy { factory(app,locator.value) }
    }
}