package io.github.atmaramnaik.kosel.test.objects

import io.github.atmaramnaik.kosel.element.Locator
import io.github.atmaramnaik.kosel.web.element.CustomObject

class JobDetailsForm(locator: Locator): CustomObject(locator) {
    val designationTextBox by this css "input[name='designation']"
    val companyTextBox by this css "input[name='company']"
    val saveJDButton by this css "#submitJD"
}