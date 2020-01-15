package io.github.atmaramnaik.kosel.test.objects

import io.github.atmaramnaik.kosel.element.Locator
import io.github.atmaramnaik.kosel.web.element.CustomObject

class BlogLinkContainer(locator: Locator): CustomObject(locator){
    val blogLinks by this css ".blogLink"
}