package io.github.atmaramnaik.kosel

import io.github.atmaramnaik.kosel.element.Object
import org.openqa.selenium.*

object KoselExpectedCondition{
    fun visibilityOfElementLocated(by: By): SearchContextExpectedCondition<WebElement?> {
            return object: SearchContextExpectedCondition<WebElement?> {
                override fun apply(sc: SearchContext): WebElement? {
                    return try {
                        elementIfVisible(findElement(by, sc))
                    } catch (e: StaleElementReferenceException) {
                        null
                    }
                }
            }
        }
    fun elementIfVisible(element: WebElement): WebElement? {
            return if (element.isDisplayed) element else null
        }
    private fun findElement(by: By, sc: SearchContext): WebElement {
            return try {
                sc.findElement(by)
            } catch (e: NoSuchElementException) {
                throw e
            } catch (e: WebDriverException) {
                throw e
            }
        }
}