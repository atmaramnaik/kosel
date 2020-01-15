package io.github.atmaramnaik.kosel.test.tests

import io.github.atmaramnaik.kosel.test.app.SampleApp
import io.github.atmaramnaik.kosel.test.pages.LoginPage
import io.github.atmaramnaik.kosel.test.test
import io.github.atmaramnaik.seleniumkotlin.data.User
import io.github.atmaramnaik.seleniumkotlin.data.UserCredentials
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class UserTest {
    @BeforeEach
    fun `create user`(){
        User.createUser(User("atmaram","Atmaram R Naik","test123$"))
    }
    @Test
    fun `login with valid username and password`(){
        test(ChromeDriverProfile) {
            SampleApp(it)
                    .launch<LoginPage>()
                    .login("atmaram", "test123$")
                    .assertUserName("Atmaram R Naik")
        }
    }
    @Test
    fun `user should be able to save job details`(){
        test(ChromeDriverProfile) {
            SampleApp(it)
                    .launch<LoginPage>()
                    .login("atmaram", "test123$")
                    .saveJD("Sr Con", "TW")
                    .assertCompany("TW")
                    .assertDesignation("Sr Con")
        }
    }
    @Test
    fun `user should be able to save blog`(){
        test(ChromeDriverProfile) {
            SampleApp(it)
                    .launch<LoginPage>()
                    .login("atmaram", "test123$")
                    .saveBlog("My New Blog", "This my new Blog")
                    .assertBlog("My New Blog")
        }
    }
    @Test
    fun `user should be able to navigate to his own blog`(){
        test(ChromeDriverProfile) {
            SampleApp(it)
                    .launch<LoginPage>()
                    .login("atmaram", "test123$")
                    .saveBlog("My New Blog", "This my new Blog")
                    .navigateToBlog("My New Blog")
                    .assertTitle("My New Blog")
                    .assertContent("This my new Blog")
        }
    }
    @AfterEach
    fun `delete user`(){
        User.deleteUserBlogs(UserCredentials("atmaram","test123$"))
        User.deleteUser(UserCredentials("atmaram","test123$"))
    }
}