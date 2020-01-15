package io.github.atmaramnaik.kosel.web

import io.github.atmaramnaik.kosel.PageFactoryRepository
import kotlin.reflect.KClass

open class WebPageFactoryRepository<BaseApp: WebApp<BaseApp>>:PageFactoryRepository<WebPage<BaseApp>,BaseApp> {
    private val map=HashMap<KClass<*>,(app:BaseApp)->Any>()
    override fun <T : WebPage<BaseApp>> register(page: KClass<T>, factory: (app: BaseApp) -> T) {
        map.put(page,factory);
    }

    override fun <T : WebPage<BaseApp>> getPage(page: KClass<T>, app: BaseApp): T {
        val factory=map.get(page)
        if(factory!=null)
            return factory(app) as T
        throw PageFactoryRepository.PageNotRegisteredException("Page ${page} not registerd in Repository ${this}")
    }

}
