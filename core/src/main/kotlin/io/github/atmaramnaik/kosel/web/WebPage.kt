package io.github.atmaramnaik.kosel.web

import io.github.atmaramnaik.kosel.App
import io.github.atmaramnaik.kosel.element.Locator
import io.github.atmaramnaik.kosel.Page
import io.github.atmaramnaik.kosel.web.element.CustomObject
import io.github.atmaramnaik.kosel.web.element.locator.CSS

interface WebPage<BaseApp: WebApp<BaseApp>>:Page {
    override val app: BaseApp
    val page: PageProvider<BaseApp>
        get() = PageProvider(app)
    infix fun css(locator: String): CSS {
        return CSS(this.app, this.searchContext, locator)
    }

    fun <T: CustomObject>co(locator: Locator, factory:(app:App,locator: Locator)->T):Lazy<T>{
        return lazy { factory(app,locator) }
    }
}
