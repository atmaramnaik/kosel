package io.github.atmaramnaik.kosel.test.pages

import io.github.atmaramnaik.kosel.test.app.SampleApp
import io.github.atmaramnaik.kosel.web.Launchable
import io.github.atmaramnaik.kosel.web.WebPage

class RegistrationPage(app: SampleApp) : WebPage<SampleApp>(app), Launchable {
    val userNameTextBox by this css "input[name='username']"
    val nameTextBox by this css "input[name='name']"
    val passwordTextBox by this css "input[name='password']"
    val submitButton by this css "button[type='submit']"

    override val partialUrl: String
        get() = "/register"

    fun register(username:String,name:String,password:String): MyDetailsPage {
        return page after {
            perform typing username within userNameTextBox
            perform typing name within nameTextBox
            perform typing password within passwordTextBox
            perform clickOn submitButton
        }
    }

}