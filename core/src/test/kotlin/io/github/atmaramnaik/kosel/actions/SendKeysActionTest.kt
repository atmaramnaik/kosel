package io.github.atmaramnaik.kosel.actions

import io.github.atmaramnaik.kosel.App
import io.github.atmaramnaik.kosel.Page
import io.github.atmaramnaik.kosel.element.Locator
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.openqa.selenium.WebElement

internal class SendKeysActionTest{
    val app= mockk<App>()
    val page= mockk<Page>()
    val sendKeysAction=SendKeysAction(app,"Hello")
    val locator= mockk<Locator>()
    @BeforeEach
    fun mockCalls(){
        every { app.slow }.returns(1L)
        every { page.app }.returns(app)
    }
    @Test
    fun `should sendkeys to single element`(){
        val el= mockk<WebElement>()
        every { el.sendKeys(any()) }.returns(Unit)
        every { locator.findOne() }.returns(el)
        sendKeysAction within locator
        verify { locator.findOne() }
        verify { el.sendKeys("Hello") }
    }
}