import io.github.atmaramnaik.kosel.test.app.SampleApp
import io.github.atmaramnaik.kosel.test.pages.RegistrationPage
import io.github.atmaramnaik.kosel.test.test
import io.github.atmaramnaik.kosel.test.tests.ChromeDriverProfile
import io.github.atmaramnaik.seleniumkotlin.data.User
import io.github.atmaramnaik.seleniumkotlin.data.UserCredentials
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test

class RegistrationTests {
    @Test
    fun `user can register`(){
        test(ChromeDriverProfile) {
            SampleApp(it)
                    .launch<RegistrationPage>()
                    .register("test1", "Atmaram", "test123$")
                    .assertUserName("Atmaram")
        }
    }
    @AfterEach
    fun `unregister user`(){
        User.deleteUser(UserCredentials("test1","test123$"))
    }
}