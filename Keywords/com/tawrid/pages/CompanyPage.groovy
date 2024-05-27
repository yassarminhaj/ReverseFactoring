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

import internal.GlobalVariable

public class CompanyPage {

	public static void searchCompnayCode(String companyCode) {
		CommonFunctions.attachScreenshot()
		CommonFunctions.attachLog('Select Company Code from the list')
		WebUI.waitForElementAttributeValue(findTestObject('CompanyPage/CountryList'), "placeholder", "Company Code", 60)
		WebUI.click(findTestObject('CompanyPage/CountryList'))
		WebUI.clearText(findTestObject('CompanyPage/CompanyCodeField'))
		WebUI.sendKeys(findTestObject('CompanyPage/CompanyCodeField'), companyCode)
		TestObject dropdownValue = new TestObject('DropDownValue')
		dropdownValue.addProperty('xpath', ConditionType.EQUALS, ".//*[text()='"+companyCode+"']")
		WebUI.click(dropdownValue)
	}
	/*

	public static void searchCompanyCode(String companyCode) {

		CommonFunctions.attachScreenshot()
		CommonFunctions.attachLog('Select Company Code from the list')
		WebUI.click(findTestObject('CompanyPage/CountryList'))
		WebUI.sendKeys(findTestObject('CompanyPage/CompanyCodeField'), companyCode)
		TestObject dropdownValue = new TestObject('DropDownValue')
		dropdownValue.addProperty('xpath', ConditionType.EQUALS, ".//span[text()='"+companyCode+"']")
		WebUI.click(dropdownValue)
	}
	*/

	public static void clickUpdateKYCResult() {
		CommonFunctions.attachLog('Click Update KYC Result')
		WebUI.click(findTestObject("CompanyPage/UpdateKYCResultButton"))
	}

	public static void clickResetAdminPassword() {
		CommonFunctions.attachLog('Click Reset Admin Password')
		WebUI.click(findTestObject("CompanyPage/ResetAdminPasswordButton"))
		CommonFunctions.attachScreenshot()
	}

	public static String getKYCStatus() {
		return WebUI.getText(findTestObject('CompanyPage/KYCProcessCompletedLabel'))
	}

	public static String getStatus() {
		return WebUI.getText(findTestObject('CompanyPage/StatusLabel'))
	}

	public static boolean verifyUpdateKYCButton() {
		return WebUI.verifyElementPresent(findTestObject('CompanyPage/UpdateKYCResultButton'), 10)
	}
}
