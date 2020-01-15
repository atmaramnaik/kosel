package io.github.atmaramnaik.kosel.test

import org.openqa.selenium.WebDriver
fun test(profile: Profile,block:(WebDriver)->Unit){
    val driver=profile.getDriver();
    try {
        block(driver)
    } catch (tw:Throwable){
        throw tw
    } finally {
        driver.close()
    }
}