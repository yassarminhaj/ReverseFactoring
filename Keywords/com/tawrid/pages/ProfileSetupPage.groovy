package com.tawrid.pages

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.katalon.extent.report.ExtentReport
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as driver
import com.tawrid.data.PropertyFile
import com.tawrid.function.CommonFunctions
import com.tawrid.function.LanguageDetector

import internal.GlobalVariable

public class ProfileSetupPage {

	public int funderCode = 10004


	public void enterFunderCode() {


		CommonFunctions.attachLog('Enter Funder Code and Search')
		driver.click(findTestObject('ProfileSetupPage/FunderCodeList'))
		driver.sendKeys('ProfileSetupPage/FunderCodeField', "10004")

		TestObject funderCode = new TestObject()
		funderCode.addProperty("xpath", ConditionType.EQUALS, "//span[text()='10004']")
	}

	public static void searchFunderCode(String val) {

		CommonFunctions.attachLog('Enter Funder Code and Search')
		driver.click(findTestObject('ProfileSetupPage/FunderCodeList'))
		driver.sendKeys('ProfileSetupPage/FunderCodeField', val)

		TestObject funderCode = new TestObject()
		funderCode.addProperty("xpath", ConditionType.EQUALS, "//span[text()='"+val+"']")
		driver.click(funderCode)
		// We need to catch exception and say if its not here then test fails
	}

	public static void clickProductOnBoarding() {
		CommonFunctions.attachLog('Click Product On-Boarding Menu Option')
		driver.click(findTestObject('MenuPage/ProductOn-BoardingLabel'))
	}

	public static void clickProfileSetup() {
		CommonFunctions.attachLog('Click Profile Setup Menu Option')
		driver.click(findTestObject('MenuPage/ProfileSetupLabel'))
		CommonFunctions.attachScreenshot()
	}
}
