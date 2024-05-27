import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import java.awt.peer.MenuPeer as MenuPeer
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
import com.tawrid.pages.CompanyPage as CompanyPage
import com.tawrid.pages.DashboardPage as DashboardPage
import com.tawrid.pages.IndexPage as IndexPage
import com.tawrid.pages.MenuPage as MenuPage
import com.tawrid.pages.ProfileSetupPage as ProfileSetupPage
import com.tawrid.pages.ResetPasswordPage as ResetPasswordPage
import com.tawrid.pages.SetupPage as SetupPage
import com.tawrid.pages.SsoSignOffPage as SsoSignOffPage
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

SetupPage.launchApplicationURL(GlobalVariable.URL_TAWID_PROTOL)

IndexPage.setLanguageForApplication(GlobalVariable.LANGUAGE)

IndexPage.enterComapany(GlobalVariable.COMPANY)

IndexPage.enterUserName(GlobalVariable.USERNAME)

IndexPage.enterPassword(GlobalVariable.PASSWORD)

IndexPage.clickLogin()

DashboardPage.clickCustomerOnBoarding()

DashboardPage.clickCompanyLabel()

CompanyPage.searchCompnayCode(GlobalVariable.COMPANYCODE)

CompanyPage.clickResetAdminPassword()

ResetPasswordPage.verifyResetPasswordPopup()

ResetPasswordPage.clickChooseOneUser("ADMINISTRATOR")

ResetPasswordPage.enterInitialPassword("Testing@1")

ResetPasswordPage.clickOnSubmit()

DashboardPage.clickOnLogoutButton()

SsoSignOffPage.clickOnSignOnButton()

IndexPage.enterComapany(GlobalVariable.COMPANYCODE)

IndexPage.enterUserName('ADMINISTRATOR')

IndexPage.enterPassword('PLGTm/4mhzB1kc5cuai4YQ==')

IndexPage.clickLogin()