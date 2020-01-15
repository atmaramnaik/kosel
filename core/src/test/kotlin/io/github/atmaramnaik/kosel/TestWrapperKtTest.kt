package io.github.atmaramnaik.kosel

import io.github.atmaramnaik.kosel.test.Profile
import io.github.atmaramnaik.kosel.test.test
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.openqa.selenium.WebDriver

internal class TestWrapperKtTest {
    val mockProfile:Profile= mockk()
    val driver:WebDriver= mockk()
    @Test
    fun `should return driver`() {
        every { mockProfile.getDriver() }.returns(driver)
        every { driver.close() }.returns(Unit)
        test(mockProfile) {
            assertEquals(driver,it)
        }
        verify(exactly = 1) { driver.close() }
    }
    @Test
    fun `should rethrow exception`() {
        val ex:Throwable= mockk()
        every { mockProfile.getDriver() }.returns(driver)
        every { driver.close() }.returns(Unit)
        val ret=assertThrows(Throwable::class.java){
            test(mockProfile) {
                assertEquals(driver,it)
                throw ex;
            }
        }
        assertEquals(ex,ret)
        verify(exactly = 1) { driver.close() }
    }
}