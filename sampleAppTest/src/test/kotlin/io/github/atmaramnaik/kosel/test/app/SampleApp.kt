package io.github.atmaramnaik.kosel.test.app

import io.github.atmaramnaik.kosel.web.WebApp
import org.openqa.selenium.WebDriver

class SampleApp(driver: WebDriver): WebApp<SampleApp>(driver, PageFactoryRepository) {
    override val slow: Long
        get() = 10L
    override val baseUrl: String
        get() = "http://localhost:3000/ui"
}