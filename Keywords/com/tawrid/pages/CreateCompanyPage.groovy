package com.tawrid.pages

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.tawrid.function.CommonFunctions
import com.kms.katalon.core.testobject.ConditionType
import com.tawrid.data.GenerateData
import com.tawrid.data.PropertyFile

import internal.GlobalVariable as GlobalVariable



public class CreateCompanyPage {


	public static void selectCompanyType() {
		CommonFunctions.attachLog('Select CompanyType')
		WebUI.click(findTestObject('CreateCompanyPage/CompanyTypeList'))
		WebUI.click(findTestObject('CreateCompanyPage/CompanyTypeField', [('spanbuyer') : PropertyFile.readValuePropertyFile(
			'spanbuyer')]))

		String companyCode  = WebUI.getAttribute(findTestObject("Object Repository/CreateCompanyPage/CompanyCodeField"),"value")
		GlobalVariable.COMPANYCODE = companyCode
		println(GlobalVariable.COMPANYCODE)
	}

	public static void selectCompanyType(String companyType) {
		CommonFunctions.attachLog('Select CompanyType')
		WebUI.click(findTestObject('CreateCompanyPage/CompanyTypeList'))

		// there is a common way select is handled with xpath, can go in common functions
		TestObject companyTypeOption = new TestObject()
		companyTypeOption.addProperty("xpath", ConditionType.EQUALS, "//span[text()='"+companyType+"']")
		WebUI.click(companyTypeOption)

		String companyCode  = WebUI.getAttribute(findTestObject("Object Repository/CreateCompanyPage/CompanyCodeField"),"value")
		GlobalVariable.COMPANYCODE = companyCode
	}

	public static void enterCompanyName() {
		CommonFunctions.attachLog('InputCompanyName')
		String companyName = GenerateData.generateCompanyName()
		WebUI.setText(findTestObject('CreateCompanyPage/CompanyNameField'), companyName)
	}

	public static void enterCompanyRegistrationID() {
		CommonFunctions.attachLog('Input Company RegistrationID')
		String companyNumber = GenerateData.generateCompanyNumber()


		WebUI.setText(findTestObject('CreateCompanyPage/CompanyRegistrationIDField'), companyNumber)
		// need to write the companyNumber in test data file
	}

	public static void selectIndustry() {
		CommonFunctions.attachLog('Select Industry')

		WebUI.click(findTestObject('Object Repository/CreateCompanyPage/IndustryList'))
		//select random method needs to be added in the common functions.
		WebUI.click(findTestObject('Object Repository/CreateCompanyPage/IndustryOption'))
	}


	public static void enterDescription() {
		CommonFunctions.attachLog('Input Description')
		String description = GenerateData.generateDescription()


		WebUI.setText(findTestObject('CreateCompanyPage/DescriptionField'), description)
	}

	public static void enterWebURL() {
		CommonFunctions.attachScreenshot()

		CommonFunctions.attachLog('Input WebURL')
		WebUI.setText(findTestObject('CreateCompanyPage/WebURLField'), 'https://www.google.com')
	}


	public static void enterCompanyAddress() {
		CommonFunctions.attachLog('Input Company Address')
		WebUI.scrollToElement(findTestObject('CreateCompanyPage/AddressLabel', [('divaddress') : PropertyFile.readValuePropertyFile(
			'divaddress')]), GlobalVariable.SHORT_WAIT)
		WebUI.setText(findTestObject('CreateCompanyPage/CompanyAddressField'), 'Address')
	}

	public static void enterProvince() {
		CommonFunctions.attachLog('Input Province')
		WebUI.setText(findTestObject('CreateCompanyPage/ProvinceField'), 'State')
	}

	public static void enterCity() {
		CommonFunctions.attachLog('Input Company City')
		WebUI.setText(findTestObject('CreateCompanyPage/CityField'), 'City')
	}

	public static void enterCompanyEmail() {
		CommonFunctions.attachLog('Input Company Email')
		WebUI.setText(findTestObject('CreateCompanyPage/EmailAddressField'), 'abc@gmail.com')
	}


	public static void selectTimezone() {
		CommonFunctions.attachLog('Select Timezone')

		WebUI.scrollToElement(findTestObject('Object Repository/CreateCompanyPage/TaskProcessControlLabel'), GlobalVariable.SHORT_WAIT)

		WebUI.click(findTestObject('CreateCompanyPage/TimezoneField'))

		WebUI.enhancedClick(findTestObject('CreateCompanyPage/TimezoneOption', [('spanasiariyadh') : PropertyFile.readValuePropertyFile(
			'spanasiariyadh')]))
		WebUI.delay(2)
		CommonFunctions.attachScreenshot()
	}

	public static void clickAccessibilityTab() {
		CommonFunctions.attachLog('Click Create Company Accessibility Tab')
		WebUI.enhancedClick(findTestObject('Object Repository/CreateCompanyPage/AccessibilityTab'))
		CommonFunctions.attachScreenshot()
	}

	public static void selectAccessibilityRightAllCheckbox() {
		CommonFunctions.attachLog('Select Accessibility Right All Checkbox')
		WebUI.enhancedClick(findTestObject('Object Repository/CreateCompanyPage/SelectAllCheck'))
	}

	public static void clickAccessibilityRF() {
		CommonFunctions.attachLog('click on Accessibility RF label')
		WebUI.enhancedClick(findTestObject('Object Repository/CreateCompanyPage/CreateCompanyPage_RFButton'))
	}

	public static void clickSubmit() {
		CommonFunctions.attachLog('Click on Submit Button')
		WebUI.enhancedClick(findTestObject('Object Repository/CreateCompanyPage/SubmitButton'))
	}

	public static void switchDualControl(String Val) {
		//TestObject theObj = findTestObject('CreateCompanyPage/DualControlSlider', [('YesOrNo') : Val])

		WebUI.scrollToElement(findTestObject('Object Repository/CreateCompanyPage/TaskProcessControlLabel'), 10)
		TestObject dualControlSlider = new TestObject()
		dualControlSlider.addProperty("xpath", ConditionType.EQUALS, "//input[@name='dualControlFlag']/parent::div/div")
		String theVal = WebUI.getAttribute(dualControlSlider, "class")
		if(theVal.contains("active") && Val.equals("No"))
			WebUI.click(findTestObject('CreateCompanyPage/DualControlSlider'))
		else
			println("We need not click")
	}
}
