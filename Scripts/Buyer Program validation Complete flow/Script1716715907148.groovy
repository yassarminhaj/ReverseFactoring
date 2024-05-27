import com.tawrid.function.CommonFunctions
import com.tawrid.pages.ChangePasswordPage
import com.tawrid.pages.CompanyEntityPage
import com.tawrid.pages.CompanyPage
import com.tawrid.pages.CreateCompanyAcknowledgePage
import com.tawrid.pages.CreateCompanyPage
import com.tawrid.pages.DashboardPage
import com.tawrid.pages.IndexPage
import com.tawrid.pages.InvoiceUploadPage
import com.tawrid.pages.KYCUpdatePage
import com.tawrid.pages.MenuPage
import com.tawrid.pages.ProfileSetupPage
import com.tawrid.pages.ResetPasswordPage
import com.tawrid.pages.SetupPage
import com.tawrid.pages.SsoSignOffPage

import internal.GlobalVariable


/*
 * This test case ensures that once a funder company is created the profile is autocreated.
 * However if the KYC is not verified the solution restricts customer to create a program.
 *
 * */
not_run: DashboardPage.setLanguageForApplication(GlobalVariable.LANGUAGE)

// Test Case 1(Reg_009) : Create a Funder with No Dual Control by a user with No Dual Control
SetupPage.launchApplicationURL(GlobalVariable.URL_TAWID_PROTOL)

IndexPage.setLanguageForApplication(GlobalVariable.LANGUAGE)

IndexPage.enterComapany(GlobalVariable.COMPANY)

IndexPage.enterUserName(GlobalVariable.USERNAME)

IndexPage.enterPassword(GlobalVariable.PASSWORD)

IndexPage.clickLogin()

DashboardPage.clickCustomerOnBoarding()

DashboardPage.clickCompanyLabel()

CompanyEntityPage.clickCreate()

CreateCompanyPage.selectCompanyType('BUYER')

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

println(GlobalVariable.COMPANYCODE)

String ExpectedMessage = ('Company ' + GlobalVariable.COMPANYCODE) + ' has been submitted for processing.'

String ActualMessage = CreateCompanyAcknowledgePage.getSubmittedSuccessfullyMessage()

if (ActualMessage.equals(ExpectedMessage)) {
    CommonFunctions.captureExpectedResult('The Company Creation Message is Displayed as Expected')
} else {
    CommonFunctions.captureExpectedResult((('The was Expecting: ' + ExpectedMessage) + ' but solution displayed: ') + ActualMessage)
}

CreateCompanyAcknowledgePage.clickViewTransactionStatusButton()

CompanyPage.searchCompnayCode(GlobalVariable.COMPANYCODE)

CompanyPage.getKYCStatus().equals('No')

CompanyPage.getStatus().equals('Verified')

CommonFunctions.captureExpectedResult('The company is created successfully and the status are displayed as expected')

MenuPage.clickProductOnBoarding()

MenuPage.clickReverseFactoring()

MenuPage.clickProfileSetup()

ProfileSetupPage.searchFunderCode(GlobalVariable.COMPANYCODE)

ProfileSetupPage.verifyFunderCodeShouldNotDisplay()

DashboardPage.clickCustomerOnBoarding()

DashboardPage.clickCompanyLabel()

CompanyPage.searchCompnayCode(GlobalVariable.COMPANYCODE)

CompanyPage.clickUpdateKYCResult()

KYCUpdatePage.clickVerify()

KYCUpdatePage.verifyConfirmationDialogue()

KYCUpdatePage.clickConfirm()

KYCUpdatePage.verifyKycSubmittedSuccessfully('Company Kyc Flag '+GlobalVariable.COMPANYCODE+' has been submitted for processing.')

CreateCompanyAcknowledgePage.clickViewTransactionStatusButton()

MenuPage.clickProductOnBoarding()

MenuPage.clickReverseFactoring()

MenuPage.clickProfileSetup()

ProfileSetupPage.searchFunderCode(GlobalVariable.COMPANYCODE)

//ProfileSetupPage.verifyFunderCodeShouldDisplay()

DashboardPage.clickCustomerOnBoarding()

DashboardPage.clickCompanyLabel()

CompanyPage.searchCompnayCode(GlobalVariable.COMPANYCODE)

CompanyPage.clickResetAdminPassword()

ResetPasswordPage.verifyResetPasswordPopup()

ResetPasswordPage.clickChooseOneUser('ADMINISTRATOR')

ResetPasswordPage.enterInitialPassword('Testing@1')

ResetPasswordPage.clickOnSubmit()

DashboardPage.clickOnLogoutButton()

SsoSignOffPage.clickOnSignOnButton()

IndexPage.enterComapany(GlobalVariable.COMPANYCODE)

IndexPage.enterUserName('ADMINISTRATOR')

IndexPage.enterPassword('PLGTm/4mhzDkkUX0cje2WQ==')

IndexPage.clickLogin()

ChangePasswordPage.verifyChangePasswordPopup()

ChangePasswordPage.enterOldPassword('Testing@1')

ChangePasswordPage.enterNewPassword('Testing@2')

ChangePasswordPage.enterConfirmNewPassword('Testing@2')

ChangePasswordPage.clickOnSubmit()

ChangePasswordPage.verifyChangePasswordSubmittedSuccessfully('Password is changed.')

ChangePasswordPage.clickOkButton()

IndexPage.enterComapany(GlobalVariable.COMPANYCODE)

IndexPage.enterUserName('ADMINISTRATOR')

IndexPage.enterPassword('PLGTm/4mhzCEtyJzMSSXHg==')

IndexPage.clickLogin()

MenuPage.clickReverseFactoring()

MenuPage.clickInvoiceSubmission()

InvoiceUploadPage.clickInvoiceUploadButton()

//InvoiceUploadPage.downlaodTemplateFile()
InvoiceUploadPage.uplaodTemplateFile()

InvoiceUploadPage.verifyFileTemplateUploadedSuccessfuly("Invoice_Upload.RFIV.csv")

InvoiceUploadPage.clickOnFinalUplaodButton()

