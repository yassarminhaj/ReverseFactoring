import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.annotation.AfterTestSuite
import com.kms.katalon.core.annotation.BeforeTestCase
import com.kms.katalon.core.annotation.BeforeTestSuite
import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.context.TestSuiteContext
import com.tawrid.function.CommonFunctions
import com.tawrid.pages.IndexPage
import com.tawrid.pages.SetupPage
import com.tawrid.pages.TeardownPage

import internal.GlobalVariable

class LoginListener {

	//@BeforeTestCase
	def sampleBeforeTestCase(TestCaseContext testCaseContext) {

		SetupPage.launchApplicationURL(GlobalVariable.URL_TAWID_PROTOL)

		IndexPage.setLanguageForApplication(GlobalVariable.LANGUAGE)


		IndexPage.enterComapany(GlobalVariable.COMPANY)


		IndexPage.enterUserName(GlobalVariable.USERNAME)


		IndexPage.enterPassword(GlobalVariable.PASSWORD)


		IndexPage.clickLogin()
	}


	//@AfterTestCase
	def sampleAfterTestCase(TestCaseContext testCaseContext) {
		//TeardownPage.terminateBrowser()
	}
}