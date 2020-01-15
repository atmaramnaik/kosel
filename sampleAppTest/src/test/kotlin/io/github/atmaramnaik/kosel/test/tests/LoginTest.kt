package io.github.atmaramnaik.kosel.test.tests

import io.github.atmaramnaik.kosel.test.app.SampleApp
import io.github.atmaramnaik.kosel.test.pages.LoginPage
import io.github.atmaramnaik.kosel.test.test
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class LoginTest {

    @Test
    fun `should be able to login`(){
        test(ChromeDriverProfile) {
            SampleApp(it)
                    .launch<LoginPage>()
                    .loginWithInvalidCredentials("someone","test123$")
                    .assertError("You have provided invalid credentials")
        }
    }
}