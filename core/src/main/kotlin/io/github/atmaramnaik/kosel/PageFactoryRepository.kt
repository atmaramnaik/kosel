package io.github.atmaramnaik.kosel

import java.lang.RuntimeException
import kotlin.reflect.KClass

interface PageFactoryRepository<Base:Page,BaseApp:App> {
    fun <T:Base> register(page:KClass<T>,factory:(app:BaseApp)->T)
    fun <T:Base> getPage(page:KClass<T>,app:BaseApp):T
    class PageNotRegisteredException(message:String):RuntimeException(message)
}