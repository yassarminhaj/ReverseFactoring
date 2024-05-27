import com.tawrid.function.CommonFunctions as CommonFunctions
import com.tawrid.pages.ChangePasswordPage as ChangePasswordPage
import com.tawrid.pages.CompanyEntityPage as CompanyEntityPage
import com.tawrid.pages.CompanyPage as CompanyPage
import com.tawrid.pages.CreateCompanyAcknowledgePage as CreateCompanyAcknowledgePage
import com.tawrid.pages.CreateCompanyPage as CreateCompanyPage
import com.tawrid.pages.DashboardPage as DashboardPage
import com.tawrid.pages.IndexPage as IndexPage
import com.tawrid.pages.InvoiceUploadPage as InvoiceUploadPage
import com.tawrid.pages.KYCUpdatePage as KYCUpdatePage
import com.tawrid.pages.MenuPage as MenuPage
import com.tawrid.pages.ResetPasswordPage as ResetPasswordPage
import com.tawrid.pages.SetupPage as SetupPage
import com.tawrid.pages.SsoSignOffPage as SsoSignOffPage
import internal.GlobalVariable as GlobalVariable

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



CompanyPage.clickUpdateKYCResult()

KYCUpdatePage.clickVerify()

KYCUpdatePage.verifyConfirmationDialogue()

KYCUpdatePage.clickConfirm()

KYCUpdatePage.verifyKycSubmittedSuccessfully()

CreateCompanyAcknowledgePage.clickViewTransactionStatusButton()

CompanyPage.clickResetAdminPassword()

ResetPasswordPage.verifyResetPasswordPopup()

ResetPasswordPage.clickChooseOneUser()

ResetPasswordPage.enterInitialPassword()

ResetPasswordPage.clickOnSubmit()

DashboardPage.clickOnLogoutButton()

SsoSignOffPage.clickOnSignOnButton()

IndexPage.enterComapany(GlobalVariable.COMPANYCODE)

IndexPage.enterUserName('ADMINISTRATOR')

IndexPage.enterPassword('PLGTm/4mhzDkkUX0cje2WQ==')

IndexPage.clickLogin()

ChangePasswordPage.verifyChangePasswordPopup()

ChangePasswordPage.enterOldPassword()

ChangePasswordPage.enterNewPassword()

ChangePasswordPage.enterConfirmNewPassword()

ChangePasswordPage.clickOnSubmit()

ChangePasswordPage.verifyChangePasswordSubmittedSuccessfully()

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

InvoiceUploadPage.verifyFileTemplateUploadedSuccessfuly()

InvoiceUploadPage.clickOnFinalUplaodButton()