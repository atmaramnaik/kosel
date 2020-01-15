package io.github.atmaramnaik.kosel

import io.mockk.mockk
import org.junit.jupiter.api.Test

class PageTests {
    val app:App= mockk()
    val page=object:Page{
        override val app: App
            get() = this@PageTests.app

    }
    @Test
    fun `should return check object`(){
        assert(page.assertThat!=null)
    }
}