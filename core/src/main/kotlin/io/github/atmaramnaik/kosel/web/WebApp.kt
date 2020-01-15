package io.github.atmaramnaik.kosel.web

import io.github.atmaramnaik.kosel.App
import org.openqa.selenium.WebDriver
import kotlin.reflect.KClass

abstract class WebApp<BaseApp: WebApp<BaseApp>>(override val driver: WebDriver, private val webPageRepository: WebPageFactoryRepository<BaseApp>):App {
    abstract val baseUrl:String
    inline fun <reified T> launch(vararg params:String):T where T: WebPage<BaseApp>, T: Launchable {
        val page=page(T::class)
        driver.get( String.format(baseUrl+page.partialUrl,*params))
        return page
    }
    inline fun <reified T> page():T where T: WebPage<BaseApp> {
        return page(T::class)
    }

    fun <T> page(kClass: KClass<T>):T where T: WebPage<BaseApp> {
        return webPageRepository.getPage(kClass,this as BaseApp);
    }
}