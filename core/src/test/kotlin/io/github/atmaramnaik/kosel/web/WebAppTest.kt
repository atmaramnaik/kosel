package io.github.atmaramnaik.kosel.web

import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.openqa.selenium.WebDriver

class WebAppTest {
    object factoryRepository: WebPageFactoryRepository<SampleApp>(){
        init {
            register(LoginPage::class, WebAppTest::LoginPage)
        }
    }
    val webDriver= mockk<WebDriver>()
    class SampleApp(driver: WebDriver): WebApp<SampleApp>(driver, factoryRepository){
        override val baseUrl: String
            get() = "http://localhost:3000"
    }

    class LoginPage(override val app: SampleApp): WebPage<SampleApp>, Launchable {
        override val partialUrl: String
            get() = "/test"

    }
    val app= SampleApp(webDriver)
    @Test
    fun `should launch page`(){
        every { webDriver.get(any()) }.returns(Unit)
        assertDoesNotThrow {
            app.launch<LoginPage>()
        }
    }
}