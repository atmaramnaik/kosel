package io.github.atmaramnaik.kosel.test

import io.github.atmaramnaik.kosel.App
import io.github.atmaramnaik.kosel.Page
import org.openqa.selenium.WebDriver
import java.lang.RuntimeException
interface Profile{
    fun getDriver():WebDriver
}