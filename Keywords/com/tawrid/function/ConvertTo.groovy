package com.tawrid.function

public class ConvertTo {

	public static String englishToArabic(String englishText) {
		StringBuilder arabicText = new StringBuilder()

		for (char c : englishText.toCharArray()) {
			switch (c) {
				case 'a':
					arabicText.append('ا') // Arabic equivalent of 'a'

					break
				case 'b':
					arabicText.append('ب') // Arabic equivalent of 'b'

					break
				case 'c':
					arabicText.append('س') // Arabic equivalent of 'c'

					break
				case 'd':
					arabicText.append('د') // Arabic equivalent of 'd'

					break
				case 'e':
					arabicText.append('ع') // Arabic equivalent of 'e'

					break
				case 'f':
					arabicText.append('ف') // Arabic equivalent of 'f'

					break
				case 'g':
					arabicText.append('ج') // Arabic equivalent of 'g'

					break
				case 'h':
					arabicText.append('ه') // Arabic equivalent of 'h'

					break
				case 'i':
					arabicText.append('ي') // Arabic equivalent of 'i'

					break
				case 'j':
					arabicText.append('ج') // Arabic equivalent of 'j'

					break
				case 'k':
					arabicText.append('ك') // Arabic equivalent of 'k'

					break
				case 'l':
					arabicText.append('ل') // Arabic equivalent of 'l'

					break
				case 'm':
					arabicText.append('م') // Arabic equivalent of 'm'

					break
				case 'n':
					arabicText.append('ن') // Arabic equivalent of 'n'

					break
				case 'o':
					arabicText.append('و') // Arabic equivalent of 'o'

					break
				case 'p':
					arabicText.append('ب') // Arabic equivalent of 'p'

					break
				case 'q':
					arabicText.append('ق') // Arabic equivalent of 'q'

					break
				case 'r':
					arabicText.append('ر') // Arabic equivalent of 'r'

					break
				case 's':
					arabicText.append('س') // Arabic equivalent of 's'

					break
				case 't':
					arabicText.append('ت') // Arabic equivalent of 't'

					break
				case 'u':
					arabicText.append('و') // Arabic equivalent of 'u'

					break
				case 'v':
					arabicText.append('ف') // Arabic equivalent of 'v'

					break
				case 'w':
					arabicText.append('و') // Arabic equivalent of 'w'

					break
				case 'x':
					arabicText.append('ك') // Arabic equivalent of 'x'

					break
				case 'y':
					arabicText.append('ي') // Arabic equivalent of 'y'

					break
				case 'z':
					arabicText.append('ز') // Arabic equivalent of 'z'

					break
				default:
					arabicText.append(c) // Keep other characters as it is
			}
		}

		return arabicText
	}
}
