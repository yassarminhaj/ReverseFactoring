package com.tawrid.data

import com.kms.katalon.core.annotation.Keyword
import com.tawrid.function.ConvertTo

import internal.GlobalVariable

public class GenerateData {


	public static generateRandomEmail() {
		def characters = ('a'..'z').toList()
		def random = new Random()
		def email= (1..8).collect { characters[random.nextInt(characters.size())] }.join() +"@gmail.com"
		if(GlobalVariable.LANGUAGE=="English") {
			return email
		}
		else if(GlobalVariable.LANGUAGE=="Arabic") {
			return ConvertTo.englishToArabic(email)
		}
	}

	public static generateCompanyName() {
		def characters = ('a'..'z').toList()
		def random = new Random()
		def companyName= "Tawrid" + (1..7).collect { characters[random.nextInt(characters.size())] }.join()
		if(GlobalVariable.LANGUAGE=="English") {
			return companyName
		}
		else if(GlobalVariable.LANGUAGE=="Arabic") {
			return ConvertTo.englishToArabic(companyName)
		}
	}




	public static generateCompanyNumber() {
		def characters = (1..9).toList()
		def random = new Random()
		def companyNumber = (0..10).collect { characters[random.nextInt(characters.size())] }.join()
		return companyNumber
	}



	public static generateTaxId() {
		def characters = (1..9).toList()
		def random = new Random()
		def taxId = (0..10).collect { characters[random.nextInt(characters.size())] }.join()
		return taxId
	}


	public static generateDescription() {
		def characters = ('a'..'z').toList()
		def random = new Random()
		def description= "Descrition_" + (1..9).collect { characters[random.nextInt(characters.size())] }.join()
		if(GlobalVariable.LANGUAGE=="English") {
			return description
		}
		else if(GlobalVariable.LANGUAGE=="Arabic") {
			return ConvertTo.englishToArabic(description)
		}
	}


	def generateMobNo() {
		def characters = (1..8).toList()
		def random = new Random()
		def mobNo = (0..7).collect { characters[random.nextInt(characters.size())] }.join()
		return mobNo
	}

	def generateSAMNo() {
		def characters = (1..9).toList()
		def random = new Random()
		def samNo = (1..9).collect { characters[random.nextInt(characters.size())] }.join()
		return samNo
	}


	def generateProductCode() {
		def characters = (1..254).toList()
		def random = new Random()
		def productCode = (1..1).collect { characters[random.nextInt(characters.size())] }.join()
		return productCode
	}



	def generateNumb_2digit() {
		def characters = (1..99).toList()
		def random = new Random()
		def Numb = (1..1).collect { characters[random.nextInt(characters.size())] }.join()
		return Numb
	}
}
