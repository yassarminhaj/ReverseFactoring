package com.tawrid.pages

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.tawrid.function.CommonFunctions
import com.tawrid.function.LanguageDetector


public class IndexPage {

	public static void enterComapany(String company) {
		CommonFunctions.attachLog('Input Comapany')
		WebUI.setText(findTestObject('IndexPage/CompanyField'), company)
	}

	public static void enterUserName(String username) {
		CommonFunctions.attachLog('Input Username')
		WebUI.setText(findTestObject('IndexPage/UsernameField'), username)
	}

	public static void enterPassword(String password) {
		CommonFunctions.attachLog('Input Encrypted Paswword')
		WebUI.setEncryptedText(findTestObject('IndexPage/PasswordField'), password)
	}

	public static void clickLogin() {
		CommonFunctions.attachLog('Click on Login Button')
		WebUI.click(findTestObject('IndexPage/LoginButton'))
	}

	public static void verifyApplicationTitle(String title) {
		String strTtile = WebUI.getWindowTitle()
		WebUI.verifyMatch(strTtile, title, false)
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
					WebUI.selectOptionByValue(findTestObject('IndexPage/LanguageList'), "en_US", false)
					break
				}
			case 'Arabic':
				WebUI.selectOptionByValue(findTestObject('IndexPage/LanguageList'), "ar_SA", false)
				break
			default:
				println 'Invalid Case'

				break
		}
	}
}
