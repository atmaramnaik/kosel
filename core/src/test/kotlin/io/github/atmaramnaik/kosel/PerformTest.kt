package io.github.atmaramnaik.kosel

import io.github.atmaramnaik.kosel.element.Locator
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.openqa.selenium.WebElement

internal class PerformTest{
    val app= mockk<App>()
    val page= mockk<Page>()
    val perform= Perform(app)
    val element=mockk<Locator>()
    @BeforeEach
    fun mockCalls(){
        every { app.slow }.returns(1L)
        every { page.app }.returns(app)
    }
    @Test
    fun `should click on element`(){
        val el=mockk<WebElement>()
        every { element.findOne()}.returns(el)
        every {el.click()}.returns(Unit)
        perform clickOn element
        verify(exactly=1) { el.click() }
    }
}