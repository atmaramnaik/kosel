package io.github.atmaramnaik.kosel.test.app

import io.github.atmaramnaik.kosel.test.pages.*
import io.github.atmaramnaik.kosel.web.WebPageFactoryRepository
import io.github.atmaramnaik.seleniumkotlin.webapp.pages.MemberPage

object PageFactoryRepository: WebPageFactoryRepository<SampleApp>() {
    init {
        register(LoginPage::class,::LoginPage)
        register(MyDetailsPage::class,::MyDetailsPage)
        register(RegistrationPage::class,::RegistrationPage)
        register(BlogPage::class,::BlogPage)
        register(MembersPage::class,::MembersPage)
        register(MemberPage::class,::MemberPage)
    }
}