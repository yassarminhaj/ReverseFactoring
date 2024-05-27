package com.tawrid.pages

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.tawrid.function.CommonFunctions

import org.openqa.selenium.Keys as Keys

import internal.GlobalVariable

public class ResetPasswordPage {

	public static void verifyResetPasswordPopup() {
		CommonFunctions.attachLog("Verify Reset Password Popup")
		WebUI.verifyElementText(findTestObject("ResetPasswordPage/ResetPasswordLabel"), 'Reset Password')
		CommonFunctions.attachScreenshot()
	}

	public static void clickChooseOneUser(String user) {

		WebUI.click(findTestObject("ResetPasswordPage/ChooseOneUserLbel"))
		TestObject dropdownValue = new TestObject('DropDownValue')
		dropdownValue.addProperty('xpath', ConditionType.EQUALS, ".//span[text()='"+user+"']")
		WebUI.click(dropdownValue)
	}

	public static void enterInitialPassword(String password) {

		WebUI.clearText(findTestObject('ResetPasswordPage/InitialPasswordField'))
		WebUI.sendKeys(findTestObject('ResetPasswordPage/InitialPasswordField'), password)
	}

	public static void clickOnSubmit() {

		WebUI.click(findTestObject("ResetPasswordPage/SubmitButton"))
	}

	public static void verifyResetPasswordSubmittedSuccessfully() {
		CommonFunctions.attachLog('Company User '+GlobalVariable.COMPANYCODE+':ADMINISTRATOR has been submitted for processing.')
		WebUI.verifyElementText(findTestObject('ResetPasswordPage/ResetPasswordSubmittedSuccessfullyLabel'), 'Company User '+GlobalVariable.COMPANYCODE+':ADMINISTRATOR has been submitted for processing.', FailureHandling.STOP_ON_FAILURE)
		CommonFunctions.attachScreenshot()
	}
}
