package com.tawrid.pages
import com.kms.katalon.core.configuration.RunConfiguration
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.tawrid.function.CommonFunctions
import com.tawrid.function.RobotFileUpload

public class InvoiceUploadPage {

	public static void clickInvoiceUploadButton() {
		CommonFunctions.attachScreenshot()
		CommonFunctions.attachLog('Click Invoice Upload Button')
		WebUI.click(findTestObject('InvoiveSubmissionPage/InvoiveUploadButton'))
	}

	public static void downlaodTemplateFile() {
		CommonFunctions.attachLog('Click Downlaod Template File')
		WebUI.click(findTestObject('InvoiveSubmissionPage/DownloadTemplateButton'))
	}

	public static void uplaodTemplateFile() {
		CommonFunctions.attachLog('Click Uplaod Template File')

		WebUI.click(findTestObject('InvoiveSubmissionPage/UplaodTemplateFileButton'))
		RobotFileUpload.keywordUploadFile(RunConfiguration.getProjectDir()+"/TemplateFile/Invoice_Upload.RFIV.csv")
	}

	public static void verifyFileTemplateUploadedSuccessfuly(msgInvoiceUpload) {
		CommonFunctions.attachLog('Verify File Template Uploaded Successfuly')
		WebUI.verifyElementText(findTestObject('InvoiveSubmissionPage/UploadSuccessfulLabel'), msgInvoiceUpload)
		CommonFunctions.attachScreenshot()
	}
	public static void clickOnFinalUplaodButton() {
		CommonFunctions.attachLog('Verify File Template Uploaded Successfuly')
		WebUI.click(findTestObject('InvoiveSubmissionPage/UploadButton'))
	}
}
