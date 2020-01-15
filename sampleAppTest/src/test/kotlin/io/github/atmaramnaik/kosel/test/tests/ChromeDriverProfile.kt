package io.github.atmaramnaik.kosel.test.tests

import io.github.atmaramnaik.kosel.test.Profile
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver

object ChromeDriverProfile:Profile {
    override fun getDriver(): WebDriver {
        return ChromeDriver();
    }
}