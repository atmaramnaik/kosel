package io.github.atmaramnaik.kosel.test.pages

import io.github.atmaramnaik.kosel.test.app.SampleApp
import io.github.atmaramnaik.kosel.test.objects.MemberLinkContainer
import io.github.atmaramnaik.kosel.web.Launchable
import io.github.atmaramnaik.kosel.web.WebPage
import io.github.atmaramnaik.seleniumkotlin.webapp.pages.MemberPage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

class MembersPage(app: SampleApp): WebPage<SampleApp>(app) , Launchable {
    val membersContainer by co(css("#memberLinks"),::MemberLinkContainer)
    val abc by this css ".abc"
    override val partialUrl: String
        get() = "/members"
    fun navigateToMember(member:String): MemberPage {
        return page after {
            perform clickOn
                    first matchingElementFrom
                    membersContainer.members element
                    { link } withExactText member
        }
    }
    fun assertMembers(memberNames:List<String>):MembersPage{
        return page after {
            assertThat elements
                    membersContainer.members element
                    { link } withTexts memberNames
        }
    }
}