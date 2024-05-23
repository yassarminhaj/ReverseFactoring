package com.tawrid.pages

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.katalon.extent.report.ExtentReport
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.tawrid.data.PropertyFile
import com.tawrid.function.CommonFunctions
import com.tawrid.function.LanguageDetector

import internal.GlobalVariable

public class KYCUpdatePage {

	public static void clickVerify() {

		CommonFunctions.attachScreenshot()

		WebUI.click(findTestObject('KYCUpdatePage/VerifyButton'))
		CommonFunctions.attachLog("Clicked On verify Button")
	}

	public static void clickConfirm() {

		CommonFunctions.attachScreenshot()

		WebUI.click(findTestObject('KYCUpdatePage/ConfirmButton'))
		CommonFunctions.attachLog("Clicked On confirm Button")
	}
	
	public static void verifyConfirmationDialogue() {
		
	}
	
}
