package io.github.atmaramnaik.kosel.web

import io.github.atmaramnaik.kosel.PageFactoryRepository
import io.mockk.mockk
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
class WebPageFactoryRepositoryTest {
    class SampleApp() : WebApp<SampleApp>(mockk(), factoryRepository) {
        override val baseUrl: String
            get() = "http://localhost:3000"
    }
    open class BasePage(override val app: SampleApp): WebPage<SampleApp>{

    }
    class LoginPage(app: SampleApp): BasePage(app){
    }
    object factoryRepository: WebPageFactoryRepository<SampleApp>()
    val app= SampleApp()
    @Test
    fun `should add page to repository`(){
        factoryRepository.register(LoginPage::class, WebPageFactoryRepositoryTest::LoginPage)
        assert(factoryRepository.getPage(LoginPage::class,app) !=null)
    }

    @Test
    fun `should thorw exception if page not registerd`(){
        assertThrows<PageFactoryRepository.PageNotRegisteredException> {
            factoryRepository.getPage(LoginPage::class,app)
        }
    }
}