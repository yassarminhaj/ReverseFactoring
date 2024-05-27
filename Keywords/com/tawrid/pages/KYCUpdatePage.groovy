package com.tawrid.pages

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.katalon.extent.report.ExtentReport
import com.kms.katalon.core.model.FailureHandling
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

	public static void verifyConfirmationDialogue() {
		CommonFunctions.attachLog("Please confirm KYC Process of this company is completed!")
		WebUI.verifyElementText(findTestObject('KYCUpdatePage/KycSubmittedForProcessingLabel'), 'Please confirm KYC Process of this company is completed!', FailureHandling.STOP_ON_FAILURE)
	}

	public static void clickConfirm() {

		CommonFunctions.attachScreenshot()
		WebUI.enhancedClick(findTestObject('KYCUpdatePage/ConfirmButton'))
		CommonFunctions.attachLog("Clicked On confirm Button")
	}

	public static void verifyKycSubmittedSuccessfully(String kycMessage) {
		CommonFunctions.attachLog("Verify Kyc Submitted Successfully")
		WebUI.verifyElementText(findTestObject('KYCUpdatePage/KycSubmittedSuccessfullyLabel'), kycMessage, FailureHandling.STOP_ON_FAILURE)
		CommonFunctions.attachScreenshot()
	}
}
