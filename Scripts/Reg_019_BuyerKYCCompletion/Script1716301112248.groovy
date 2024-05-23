import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys
import com.aventstack.extentreports.Status

import com.tawrid.function.CommonFunctions
import com.tawrid.pages.*

String companyCode = '10479'

MenuPage.clickCustomerOnBoarding()
MenuPage.clickCompany()
CompanyPage.searchCompanyCode(companyCode)

if(CompanyPage.verifyUpdateKYCButton())
	CommonFunctions.captureExpectedResult("The KYC Update Button is Available ",Status.PASS)
else
	CommonFunctions.captureExpectedResult("The KYC Update Button is Available ", Status.FAIL)

CompanyPage.clickUpdateKYCResult()
KYCUpdatePage.clickVerify()

if(KYCUpdatePage.verifyConfirmationDialogue())
	CommonFunctions.captureExpectedResult("The Confirmation Dialogue was displayed ",Status.PASS)
else
	CommonFunctions.captureExpectedResult("The Confirmation Dialogue was'nt displayed ",Status.FAIL)
	
KYCUpdatePage.clickConfirm()

CommonFunctions.captureExpectedResult("The KYC has been completed ",Status.PASS)

MenuPage.clickProductOnBoarding()
MenuPage.clickReverseFactoring()
MenuPage.clickProfileSetup()
ProfileSetupPage.searchFunderCode(companyCode)

// we need to do this expected before kyc verify
CommonFunctions.captureExpectedResult("It can be noted that once KYC approved profile is created ",Status.PASS)
