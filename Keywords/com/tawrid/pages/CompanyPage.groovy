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

	public static void searchCompnayCode() {

		CommonFunctions.attachLog('Select Company Code from the list')
		WebUI.click(findTestObject('CompanyPage/CountryList'))
		WebUI.sendKeys(findTestObject('CompanyPage/CompanyCodeField'), GlobalVariable.COMPANYCODE)
		TestObject dropdownValue = new TestObject('DropDownValue')
		dropdownValue.addProperty('xpath', ConditionType.EQUALS, ".//*[text()='"+GlobalVariable.COMPANYCODE+"']")
		WebUI.click(dropdownValue)
	}

	public static void searchCompanyCode(String companyCode) {

		CommonFunctions.attachLog('Select Company Code from the list')
		WebUI.click(findTestObject('CompanyPage/CountryList'))
		WebUI.sendKeys(findTestObject('CompanyPage/CompanyCodeField'), companyCode)
		TestObject dropdownValue = new TestObject('DropDownValue')
		dropdownValue.addProperty('xpath', ConditionType.EQUALS, ".//span[text()='"+companyCode+"']")
		WebUI.click(dropdownValue)
	}

	public static void clickUpdateKYCResult() {

		WebUI.click(findTestObject("UpdateKYCResultButton"))
	}

	public static String getKYCStatus() {
		return WebUI.getText('CompanyPage/KYCProcessCompletedLabel')
	}

	public static String getStatus() {
		return WebUI.getText('CompanyPage/StatusLabel')
	}

	public static boolean verifyUpdateKYCButton() {
		return WebUI.verifyElementPresent('CompanyPage/UpdateKYCResultButton', 10)
	}
}
