package io.github.atmaramnaik.kosel.test.pages

import io.github.atmaramnaik.kosel.element.Locator
import io.github.atmaramnaik.kosel.test.app.SampleApp
import io.github.atmaramnaik.kosel.web.element.CustomObject
import io.github.atmaramnaik.kosel.web.Launchable
import io.github.atmaramnaik.kosel.web.WebPage

class LoginPage(app: SampleApp): WebPage<SampleApp>(app), Launchable {
    val loginForm by co(css(".form"),::LoginForm)
    val errorLabel by css("#error")
    class LoginForm(locator: Locator): CustomObject(locator){
        val usernameTextBox by css("input[name='username']")
        val passwordTextBox by css("input[name='password']")
        val loginButton by css("button[type='submit']")
    }

    fun login(username:String,password:String):MyDetailsPage{
        return page after {
            perform typing username within loginForm.usernameTextBox
            perform typing password within loginForm.passwordTextBox
            perform clickOn loginForm.loginButton
        }
    }

    fun loginWithInvalidCredentials(username:String,password:String):LoginPage{
        return page after {
            perform typing username within loginForm.usernameTextBox
            perform typing password within loginForm.passwordTextBox
            perform clickOn loginForm.loginButton
        }
    }
    fun assertError(message:String):LoginPage{
        return page after {
            assertThat textOf errorLabel isExactlySameAs message
        }
    }
    override val partialUrl: String
        get() = "/login"
}