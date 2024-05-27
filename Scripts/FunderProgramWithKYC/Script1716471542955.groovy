import com.tawrid.pages.IndexPage
import com.tawrid.pages.MenuPage
import com.tawrid.pages.ProfileSetupPage
import com.tawrid.pages.SetupPage

import internal.GlobalVariable as GlobalVariable

SetupPage.launchApplicationURL(GlobalVariable.URL_TAWID_PROTOL)

IndexPage.setLanguageForApplication(GlobalVariable.LANGUAGE)


IndexPage.enterComapany(GlobalVariable.COMPANY)


IndexPage.enterUserName(GlobalVariable.USERNAME)


IndexPage.enterPassword(GlobalVariable.PASSWORD)


IndexPage.clickLogin()


MenuPage.clickProductOnBoarding()
MenuPage.clickReverseFactoring()
MenuPage.clickProfileSetup()

ProfileSetupPage.searchFunderCode(GlobalVariable.COMPANYCODE)
//ProfileSetupPage.verifyFunderCodeShouldDisplay()
ProfileSetupPage.getStatus().equals("Verified")