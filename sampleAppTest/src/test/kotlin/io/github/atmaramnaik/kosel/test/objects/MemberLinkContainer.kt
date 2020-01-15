package io.github.atmaramnaik.kosel.test.objects

import io.github.atmaramnaik.kosel.element.Locator
import io.github.atmaramnaik.kosel.web.element.CustomObject

class MemberLinkContainer(locator: Locator): CustomObject(locator){
    val members by co(css(".memberRow"),::MemberSection) //by this css ".memberName"
    class MemberSection(locator: Locator): CustomObject(locator){
        val link by this css ".memberName"
    }
}