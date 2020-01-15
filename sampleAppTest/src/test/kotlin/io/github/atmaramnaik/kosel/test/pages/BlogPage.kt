package io.github.atmaramnaik.kosel.test.pages

import io.github.atmaramnaik.kosel.test.app.SampleApp
import io.github.atmaramnaik.kosel.web.WebPage

class BlogPage(app:SampleApp) : WebPage<SampleApp>(app) {
    val titleLabel by this css "#title"
    val contentLabel by this css "#content"
    fun assertTitle(title:String):BlogPage{
        return page after {
            assertThat textOf titleLabel isExactlySameAs title
        }
    }
    fun assertContent(content:String):BlogPage{
        return page after {
            assertThat textOf contentLabel isExactlySameAs content
        }
    }
}