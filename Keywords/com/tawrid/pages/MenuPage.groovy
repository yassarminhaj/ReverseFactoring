package com.tawrid.pages

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.katalon.extent.report.ExtentReport
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as driver
import com.tawrid.data.PropertyFile
import com.tawrid.function.CommonFunctions
import com.tawrid.function.LanguageDetector

import internal.GlobalVariable

public class MenuPage {



	public static void clickCustomerOnBoarding() {

		CommonFunctions.attachScreenshot()
		CommonFunctions.attachLog("Click Customer On Boarding")

		driver.waitForElementAttributeValue(findTestObject('MenuPage/CustomerOnBoardingLabel'), "class", "media-body fs-binding", GlobalVariable.LONG_WAIT)
		driver.click(findTestObject('MenuPage/CustomerOnBoardingLabel', [('spancustomeronboarding') : PropertyFile.readValuePropertyFile(
			'spancustomeronboarding')]))
	}

	public static void clickCompany() {
		CommonFunctions.attachLog('Click Company Label')
		driver.click(findTestObject('CompanyLabel', [('spancompany') : PropertyFile.readValuePropertyFile(
			'spancompany')]))
	}

	public static void clickReverseFactoring() {
		CommonFunctions.attachLog('Click Reverse Faction Menu Option')
		driver.click(findTestObject('MenuPage/ReverseFactoringLabel'))
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
