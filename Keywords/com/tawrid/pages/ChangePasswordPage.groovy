package com.tawrid.pages

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.tawrid.function.CommonFunctions

import internal.GlobalVariable

public class ChangePasswordPage {

	public static void verifyChangePasswordPopup() {
		
		CommonFunctions.attachLog("Verify Change Password Popup")

		WebUI.verifyElementText(findTestObject("ChangePasswordPage/ChangePasswordLabel"), 'Change Password')
		CommonFunctions.attachScreenshot()
		
	}


	public static void enterOldPassword(String oldPassword) {

		WebUI.sendKeys(findTestObject('ChangePasswordPage/OldPasswordField'), oldPassword)
	}

	public static void enterNewPassword(String newPassword) {
		WebUI.sendKeys(findTestObject('ChangePasswordPage/NewPasswordField'), newPassword)
	}

	public static void enterConfirmNewPassword(String newPassword) {

		WebUI.sendKeys(findTestObject('ChangePasswordPage/ConfirmNewPasswordField'), newPassword)
	}

	public static void clickOnSubmit() {

		WebUI.click(findTestObject("ChangePasswordPage/SubmitButton"))
	}

	public static void verifyChangePasswordSubmittedSuccessfully(String msgChangePassword) {
		CommonFunctions.attachLog("Verify Change Password Submitted Successfully")
		WebUI.verifyElementText(findTestObject('Object Repository/ChangePasswordPage/PasswordChangedSuccessfullyLabel'), msgChangePassword, FailureHandling.STOP_ON_FAILURE)
		CommonFunctions.attachScreenshot()
		
	}

	public static void clickOkButton() {

		WebUI.click(findTestObject("ChangePasswordPage/OKButton"))
	}
}
