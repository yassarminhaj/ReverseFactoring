package com.tawrid.data

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.configuration.RunConfiguration

import internal.GlobalVariable



public class PropertyFile {


	public static String readValuePropertyFile(String key) {
		String propertyFilePath = RunConfiguration.getProjectDir() + "/PropertyFiles/" + GlobalVariable.LANGUAGE + ".properties";

		Properties properties = new Properties();

		try {
			properties.load(new InputStreamReader(new FileInputStream(propertyFilePath), "UTF-8"));
			String value = properties.getProperty(key);

			return value;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}


	public writeValuePropertyFile(String key, String value) {
		String propertyFilePath = RunConfiguration.getProjectDir()+"/PropertyFiles/"+GlobalVariable.LANGUAGE+".properties";

		Properties properties = new Properties()
		FileInputStream inputStream = new FileInputStream(propertyFilePath)
		properties.load(inputStream)
		inputStream.close()

		properties.setProperty(key, value)

		FileOutputStream outputStream = new FileOutputStream(propertyFilePath)
		properties.store(outputStream, null)
		outputStream.close()
	}
}
