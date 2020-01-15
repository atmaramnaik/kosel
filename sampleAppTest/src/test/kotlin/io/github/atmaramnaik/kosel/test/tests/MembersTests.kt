package io.github.atmaramnaik.kosel.test.tests

import io.github.atmaramnaik.kosel.test.app.SampleApp
import io.github.atmaramnaik.kosel.test.pages.MembersPage
import io.github.atmaramnaik.kosel.test.test
import io.github.atmaramnaik.seleniumkotlin.data.User
import io.github.atmaramnaik.seleniumkotlin.data.UserCredentials
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class MembersTests {
    @BeforeEach
    fun `register user`(){
        User.createUser(User("santa","Atmaram R Naik","test123$"))
        User.createUser(User("banta","Sohan Bhogale","test123$"))
        User.createUser(User("tanta","Tanta Sing","test123$"))
    }
    @Test
    fun `verify members`(){
        test(ChromeDriverProfile) {
            SampleApp(it)
                    .launch<MembersPage>()
                    .assertMembers(listOf("Atmaram R Naik", "Sohan Bhogale", "Tanta Sing"))
        }

    }
    @Test
    fun `verify individual member`(){
        test(ChromeDriverProfile) {
            SampleApp(it)
                    .launch<MembersPage>()
                    .navigateToMember("Sohan Bhogale")
                    .assertName("Sohan Bhogale")
                    .assertNoBlogs()
        }
    }
    @AfterEach
    fun `unregister user`(){
        User.deleteUser(UserCredentials("santa","test123$"))
        User.deleteUser(UserCredentials("banta","test123$"))
        User.deleteUser(UserCredentials("tanta","test123$"))
    }
}