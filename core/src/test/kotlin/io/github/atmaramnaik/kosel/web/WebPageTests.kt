package io.github.atmaramnaik.kosel.web
import io.github.atmaramnaik.kosel.App
import io.github.atmaramnaik.kosel.element.Locator
import io.github.atmaramnaik.kosel.web.element.CustomObject
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.chrome.ChromeDriver

class WebPageTests {
    val webDriver= mockk<ChromeDriver>()
    class SampleApp(driver: WebDriver): WebApp<SampleApp>(driver, factoryRepository){
        override val baseUrl: String
            get() = "http://localhost:3000"
    }


    val app= SampleApp(webDriver)
    open class BasePage(override val app: SampleApp): WebPage<SampleApp>{

    }
    class LoginPage(app: SampleApp): BasePage(app){
        val dummyTextBox by css(".some-class")
        fun navigateToDetails(): DetailsPage {
            return page after {

            }
        }
        fun elemenetFindingMethod():DetailsPage{
            return page after {
                perform typing "Hello" within dummyTextBox
            }
        }
        fun elemenetsFindingMethod():DetailsPage{
            return page after {
                perform typing "Hello" bySelecting first matchingElementFrom dummyTextBox withExactText "Hello"
            }
        }
    }
    class DetailsPage(app: SampleApp): BasePage(app){
        val detailsSection by co(css(".details"),::DetailsSection)
        class DetailsSection(app: App, locator: Locator): CustomObject(app,locator){
            val inputTextBox by css(".input")
        }
        fun detailsInnerElementAccessingMethod():DetailsPage{
            return page after {
                perform typing "Hello" within detailsSection.inputTextBox
            }
        }
    }
    object factoryRepository: WebPageFactoryRepository<SampleApp>(){
        init {
            register(LoginPage::class, WebPageTests::LoginPage)
            register(DetailsPage::class, WebPageTests::DetailsPage)
        }
    }
    @Test
    fun `should return page after`(){
        assertDoesNotThrow {
            app.page(LoginPage::class)
                    .navigateToDetails()
        }
    }

    @Test
    fun `should find element from driver`(){
        val el=mockk<WebElement>()
        every { el.isDisplayed }.returns(true)
        every { webDriver.findElement(any()) }.returns(el)
        every { el.sendKeys(*anyVararg()) }.returns(Unit)

        assertDoesNotThrow {
            app.page(LoginPage::class)
                    .elemenetFindingMethod()
        }
        verify { webDriver.findElement(By.cssSelector(".some-class")) }
        verify { el.sendKeys("Hello") }
    }
    @Test
    fun `should find multiple element from driver`(){
        val el=mockk<WebElement>()
        val els= listOf(el)
        every { el.isDisplayed }.returns(true)
        every { webDriver.findElement(By.cssSelector(".some-class")) }.returns(el)
        every { el.text }.returns("Hello")
        every { el.sendKeys(*anyVararg()) }.returns(Unit)
        every { webDriver.findElements(any()) }.returns(els)
        assertDoesNotThrow {
            app.page(LoginPage::class)
                    .elemenetsFindingMethod()
        }
        verify { webDriver.findElements(By.cssSelector(".some-class")) }
        verify { el.sendKeys("Hello") }
    }

    @Test
    fun `should return custom object`(){
        val detailsElement:WebElement=mockk()
        val inputElement=mockk<WebElement>()
        every { detailsElement.isDisplayed }.returns(true)
        every { inputElement.isDisplayed }.returns(true)
        every { webDriver.findElement(By.cssSelector(".details")) }.returns(detailsElement)
        every { detailsElement.findElement(By.cssSelector(".input")) }.returns(inputElement)
        every { inputElement.sendKeys(*anyVararg()) }.returns(Unit)
        assertDoesNotThrow {
            app.page(LoginPage::class)
                    .navigateToDetails()
                    .detailsInnerElementAccessingMethod()
        }
        verify { webDriver.findElement(By.cssSelector(".details")) }
        verify { detailsElement.findElement(By.cssSelector(".input")) }
        verify { inputElement.sendKeys("Hello") }
    }
}