package com.tawrid.function
import com.aventstack.extentreports.ExtentTest
import com.aventstack.extentreports.MediaEntityBuilder
import com.aventstack.extentreports.Status;
import com.katalon.extent.report.ExtentReport
import com.kms.katalon.core.configuration.RunConfiguration

import internal.GlobalVariable

public class CommonFunctions {

	public static String getExecutionSourceName="TestCase"

	public static void attachScreenshot() {
		getExecutionSourceName = RunConfiguration.getExecutionSourceId()
		if(getExecutionSourceName.startsWith("Test Suite")) {
			String screenshotpathLaunched = ExtentReport.getScreenshot()

			if(GlobalVariable.LANGUAGE=="English") {
				ExtentReport.extentTest.log(Status.PASS, 'Screenshot added.', MediaEntityBuilder.createScreenCaptureFromPath(screenshotpathLaunched).build())
			}
			else if(GlobalVariable.LANGUAGE=="Arabic"){
				ExtentReport.extentTest.log(Status.PASS, 'تمت إضافة لقطة شاشة.', MediaEntityBuilder.createScreenCaptureFromPath(screenshotpathLaunched).build())
			}
		}
	}


	public static void attachLog(String details) {
		getExecutionSourceName = RunConfiguration.getExecutionSourceId()
		if(getExecutionSourceName.startsWith("Test Suite")) {
			if(GlobalVariable.LANGUAGE=="English") {
				ExtentReport.extentTest.log(Status.PASS, details)
			}
			else if(GlobalVariable.LANGUAGE=="Arabic"){
				ExtentReport.extentTest.log(Status.PASS, ConvertTo.englishToArabic(details.toLowerCase()))
			}
		}
	}

	public static void attachScreenshot(Status val) {
		getExecutionSourceName = RunConfiguration.getExecutionSourceId()
		if(getExecutionSourceName.startsWith("Test Suite")) {
			String screenshotpathLaunched = ExtentReport.getScreenshot()

			if(GlobalVariable.LANGUAGE=="English") {
				ExtentReport.extentTest.log(val, 'Screenshot added.', MediaEntityBuilder.createScreenCaptureFromPath(screenshotpathLaunched).build())
			}
			else if(GlobalVariable.LANGUAGE=="Arabic"){
				ExtentReport.extentTest.log(val, 'تمت إضافة لقطة شاشة.', MediaEntityBuilder.createScreenCaptureFromPath(screenshotpathLaunched).build())
			}
		}
	}


	public static void attachLog(String details, Status val) {
		getExecutionSourceName = RunConfiguration.getExecutionSourceId()
		if(getExecutionSourceName.startsWith("Test Suite")) {
			if(GlobalVariable.LANGUAGE=="English") {
				ExtentReport.extentTest.log(val, details)
			}
			else if(GlobalVariable.LANGUAGE=="Arabic"){
				ExtentReport.extentTest.log(val, ConvertTo.englishToArabic(details.toLowerCase()))
			}
		}
	}

	public static void captureExpectedResult(String text) {
		attachLog(text)
		attachScreenshot()
	}
}
