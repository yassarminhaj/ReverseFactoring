import com.tawrid.pages.IndexPage
import com.tawrid.pages.InvoiceUploadPage
import com.tawrid.pages.MenuPage
import com.tawrid.pages.SetupPage

import internal.GlobalVariable as GlobalVariable

SetupPage.launchApplicationURL(GlobalVariable.URL_TAWID_PROTOL)

IndexPage.setLanguageForApplication(GlobalVariable.LANGUAGE)

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

