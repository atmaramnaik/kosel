package io.github.atmaramnaik.seleniumkotlin.webapp.pages

import io.github.atmaramnaik.kosel.test.app.SampleApp
import io.github.atmaramnaik.kosel.test.objects.BlogLinkContainer
import io.github.atmaramnaik.kosel.web.WebPage

class MemberPage(app: SampleApp): WebPage<SampleApp>(app) {
    val nameLabel by this css "#name"
    val blogLinkContainer by co(css("#blogEntries"), ::BlogLinkContainer)
    fun assertName(name:String):MemberPage{
        return page after {
            assertThat textOf nameLabel isExactlySameAs name
        }
    }
    fun assertBlogsWithText(blogs:List<String>):MemberPage{
        return page after {
            assertThat elements blogLinkContainer.blogLinks withTexts blogs
        }
    }
    fun assertNoBlogs():MemberPage{
        return page after {
            assertThat element blogLinkContainer shouldNotBe present
        }
    }
}