import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.aventstack.extentreports.Status
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
import org.openqa.selenium.Keys as Keys
import com.tawrid.pages.DashboardPage as DashboardPage
import com.tawrid.pages.CompanyPage
import com.tawrid.function.CommonFunctions
import com.tawrid.pages.CompanyEntityPage as CompanyEntityPage
import com.tawrid.pages.CreateCompanyPage as CreateCompanyPage
import com.tawrid.pages.CreateCompanyAcknowledgePage as CreateCompanyAcknowledgePage

// Test Case 1(Reg_003) : Create a Buyer with No Dual Control when platform is No Dual Control

DashboardPage.clickCustomerOnBoarding()
DashboardPage.clickCompanyLabel()

CompanyEntityPage.clickCreate()
CreateCompanyPage.selectCompanyType('SUPPLIER')
CreateCompanyPage.enterCompanyName()
CreateCompanyPage.enterCompanyRegistrationID()
CreateCompanyPage.selectIndustry()
CreateCompanyPage.enterDescription()
CreateCompanyPage.enterCity()
CreateCompanyPage.switchDualControl('No')
CreateCompanyPage.clickAccessibilityTab()
CreateCompanyPage.selectAccessibilityRightAllCheckbox()
CreateCompanyPage.clickAccessibilityRF()
CreateCompanyPage.selectAccessibilityRightAllCheckbox()
CreateCompanyPage.clickSubmit()

String ExpectedMessage = "Company "+GlobalVariable.COMPANYCODE+" has been submitted for processing."
String ActualMessage = CreateCompanyAcknowledgePage.getSubmittedSuccessfullyMessage()
if(ActualMessage.equals(ExpectedMessage))
	CommonFunctions.captureExpectedResult("The Company Creation Message is Displayed as Expected", Status.PASS)
else
	CommonFunctions.captureExpectedResult("The was Expecting"+ExpectedMessage+"but solution displayed"+ActualMessage, Status.FAIL)

CreateCompanyAcknowledgePage.clickViewTransactionStatusButton()
CompanyPage.searchCompnayCode(GlobalVariable.COMPANYCODE)

CompanyPage.getKYCStatus().equals("No")
CompanyPage.getStatus().equals("Verified")

CommonFunctions.captureExpectedResult("The company is created successfully and the status are displayed as expected",Status.PASS)