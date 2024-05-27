package com.tawrid.pages

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.katalon.extent.report.ExtentReport
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.tawrid.data.PropertyFile
import com.tawrid.function.CommonFunctions
import com.tawrid.function.LanguageDetector

import groovy.transform.Undefined.EXCEPTION
import internal.GlobalVariable

public class ProfileSetupPage {

	public int funderCode = 10004



	public static void searchFunderCode(String val) {

		CommonFunctions.attachLog('Enter Funder Code and Search')
		WebUI.click(findTestObject('ProfileSetupPage/FunderCodeList'))
		WebUI.sendKeys(findTestObject('ProfileSetupPage/FunderCodeField'), val)

		// We need to catch exception and say if its not here then test fails
		/*
		 TestObject funderCode = new TestObject()
		 funderCode.addProperty("xpath", ConditionType.EQUALS, "//span[text()='"+GlobalVariable.COMPANYCODE+"']")
		 try {
		 boolean displayTrue = WebUI.verifyElementPresent(funderCode, 10)
		 if(displayTrue==true) {
		 KeywordUtil.markPassed("Funder Code should not display")
		 WebUI.click(funderCode)
		 }
		 }catch(Exception e) {
		 KeywordUtil.markPassed("Funder Code should not display")
		 }
		 */
	}

	public static void clickProductOnBoarding() {
		CommonFunctions.attachLog('Click Product On-Boarding Menu Option')
		WebUI.click(findTestObject('MenuPage/ProductOn-BoardingLabel'))
	}

	public static void clickProfileSetup() {
		CommonFunctions.attachLog('Click Profile Setup Menu Option')
		WebUI.click(findTestObject('MenuPage/ProfileSetupLabel'))
		CommonFunctions.attachScreenshot()
	}

	public static void verifyFunderCodeShouldNotDisplay() {
		CommonFunctions.attachLog('Verify Funder Code Should Not Display')
		TestObject funderCode = new TestObject()
		funderCode.addProperty("xpath", ConditionType.EQUALS, "(.//*[@fs-if='fsComponentCtrl.selectOptions.data']//ul[contains(@class,'dropdown-menu')])[1]/li")
		int elememtSize = WebUI.findWebElements(funderCode, 10).size()
		if(elememtSize <= 1) {
			KeywordUtil.markPassed("Funder Code Should Not Display")
			println("Funder Code Should Not Display")
		}
		else {
			KeywordUtil.markFailed("Funder Code is displaying Display but should not display")
		}
		CommonFunctions.attachScreenshot()
	}

	public static void verifyFunderCodeShouldDisplay() {
		CommonFunctions.attachLog('Verify Funder Code is Displaying')
		TestObject funderCode = new TestObject()
		funderCode.addProperty("xpath", ConditionType.EQUALS, "//span[text()='"+GlobalVariable.COMPANYCODE+"']")
		boolean displayTrue = WebUI.verifyElementPresent(funderCode, 10)
		if(displayTrue==false) {
			KeywordUtil.markFailed("Funder Code is Not Displaying but should display")
		}
		WebUI.click(funderCode)
		CommonFunctions.attachScreenshot()
	}

	public static String getStatus() {
		return WebUI.getText(findTestObject('ProfileSetupPage/StatusLabel'))
	}
}
