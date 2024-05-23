import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import javax.xml.bind.annotation.XmlElementDecl.GLOBAL as GLOBAL
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.tawrid.pages.CompanyEntityPage
import com.tawrid.pages.CompanyPage
import com.tawrid.pages.CreateCompanyAcknowledgePage
import com.tawrid.pages.CreateCompanyPage as CreateCompanyPage
import com.tawrid.pages.DashboardPage as DashboardPage
import com.tawrid.pages.IndexPage as IndexPage
import com.tawrid.pages.SetupPage as SetupPage
import internal.GlobalVariable as GlobalVariable

not_run: DashboardPage.setLanguageForApplication(GlobalVariable.LANGUAGE)

DashboardPage.clickCustomerOnBoarding()

DashboardPage.clickCompanyLabel()

CompanyEntityPage.clickCreate()

CreateCompanyPage.selectCompanyType()

CreateCompanyPage.inputCompanyName()

CreateCompanyPage.inputCompanyRegistrationID()

CreateCompanyPage.selectIndustry()

CreateCompanyPage.inputDescription()

CreateCompanyPage.inputWebURL()

CreateCompanyPage.inputCompanyAddress()

CreateCompanyPage.inputCompanyCity()

CreateCompanyPage.inputProvince()

CreateCompanyPage.inputCompanyEmail()

// CreateCompanyPage.selectTimezone()

CreateCompanyPage.clickCreateCompanyAccessibilityTab()

CreateCompanyPage.selectAccessibilityRightAllCheckbox()

CreateCompanyPage.clickAccessibilityRF()

CreateCompanyPage.selectAccessibilityRightAllCheckbox()

CreateCompanyPage.clickSubmitButton()

WebUI.delay(5)

CreateCompanyAcknowledgePage.verifyCreateCompanySubmition()

CreateCompanyAcknowledgePage.clickViewTransactionStatusButton()

CompanyPage.searchCompnayCode()

WebUI.delay(5)
