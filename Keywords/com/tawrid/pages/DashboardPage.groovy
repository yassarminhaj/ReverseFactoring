package com.tawrid.pages

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.katalon.extent.report.ExtentReport
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.tawrid.data.PropertyFile
import com.tawrid.function.CommonFunctions
import com.tawrid.function.LanguageDetector

import internal.GlobalVariable

public class DashboardPage {



	public static void clickCustomerOnBoarding() {

		CommonFunctions.attachScreenshot()
		CommonFunctions.attachLog("Click Customer On Boarding")

		WebUI.waitForElementAttributeValue(findTestObject('MenuPage/CustomerOnBoardingLabel'), "class", "media-body fs-binding", GlobalVariable.LONG_WAIT)
		WebUI.click(findTestObject('MenuPage/CustomerOnBoardingLabel', [('spancustomeronboarding') : PropertyFile.readValuePropertyFile(
			'spancustomeronboarding')]))
	}

	public static void clickCompanyLabel() {
		CommonFunctions.attachLog('Click Company Label')
		WebUI.click(findTestObject('MenuPage/CompanyLabel', [('spancompany') : PropertyFile.readValuePropertyFile(
			'spancompany')]))
	}

	public static void setLanguageForApplication(String stLanguagePreference) {
		String titleTest = WebUI.getWindowTitle()

		boolean bolEng = LanguageDetector.isEnglish(titleTest)

		boolean bolArib = LanguageDetector.isArabic(titleTest)

		switch (stLanguagePreference) {
			case 'English':
				if (bolEng == true) {
					break
				} else if (bolArib == true) {
					WebUI.click(findTestObject('DashboardPage/LanguageList'))
					WebUI.click(findTestObject('DashboardPage/SetLanguageLink', [('language') : 'الإنجليزية']))

					break
				}
			case 'Arabic':
				WebUI.click(findTestObject('DashboardPage/LanguageList'))
				WebUI.click(findTestObject('DashboardPage/SetLanguageLink', [('language') : 'العربية']))
				break
			default:
				println 'Invalid Case'

				break
		}
	}
}
