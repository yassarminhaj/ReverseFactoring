package com.tawrid.pages

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.tawrid.function.CommonFunctions
import com.tawrid.data.GenerateData
import com.tawrid.data.PropertyFile

import internal.GlobalVariable as GlobalVariable



public class CompanyEntityPage {

	public static void clickCreate() {

		CommonFunctions.attachScreenshot()
		CommonFunctions.attachLog('Click Create')
		WebUI.click(findTestObject('CompanyPage/CreateButton', [('spancreate') : PropertyFile.readValuePropertyFile(
			'spancreate')]))
	}
}
