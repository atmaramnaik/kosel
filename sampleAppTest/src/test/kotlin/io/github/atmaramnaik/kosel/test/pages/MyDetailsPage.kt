package io.github.atmaramnaik.kosel.test.pages

import io.github.atmaramnaik.kosel.test.app.SampleApp
import io.github.atmaramnaik.kosel.test.objects.BlogLinkContainer
import io.github.atmaramnaik.kosel.test.objects.JobDetailsForm
import io.github.atmaramnaik.kosel.web.Launchable
import io.github.atmaramnaik.kosel.web.WebPage

class MyDetailsPage(app:SampleApp): WebPage<SampleApp>(app),Launchable {
    val unregisterButton by this css "#unregister"
    val jdForm by co(css("#JobDetailsForm"), ::JobDetailsForm)

    val titleTextBox by this css "input[name='title']"
    val contentTextArea by this css "textarea[name='content']"
    val saveBlogButton by this css "#submitBlog"
    val nameLabel by this css "#name"
    val companyLabel by this css "#company"
    val designationLabel by this css "#designation"
    val blogLinkContainer by co(css("#blogEntries"), ::BlogLinkContainer)
    override val partialUrl: String
        get() = "/mydetails"

    fun unregister():MyDetailsPage{
        return page after {
            perform clickOn unregisterButton
        }
    }

    fun saveJD(designation:String,company:String):MyDetailsPage{
        return page after {
            perform typing designation within jdForm.designationTextBox
            perform typing company within jdForm.companyTextBox
            perform clickOn jdForm.saveJDButton
        }
    }

    fun assertUserName(name: String):MyDetailsPage {
        return page after {
            assertThat textOf nameLabel isExactlySameAs name
        }
    }
    fun assertCompany(company: String):MyDetailsPage {
        return page after {
            assertThat textOf companyLabel isExactlySameAs company
        }
    }
    fun assertDesignation(designation: String):MyDetailsPage {
        return page after {
            assertThat textOf designationLabel isExactlySameAs designation
        }
    }

    fun saveBlog(title: String, content: String): MyDetailsPage {
        return page after {
            perform typing title within titleTextBox
            perform typing content within contentTextArea
            perform clickOn saveBlogButton
        }
    }
    fun assertBlog(title:String): MyDetailsPage{
        return page after {
            assertThat textOf anyOne elementFrom blogLinkContainer.blogLinks isExactlySameAs title
        }
    }

    fun navigateToBlog(title: String): BlogPage {
        return page after {
            perform clickOn first matchingElementFrom blogLinkContainer.blogLinks withExactText title
        }
    }
}