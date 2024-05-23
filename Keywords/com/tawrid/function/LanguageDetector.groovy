package com.tawrid.function

public class LanguageDetector {

	public static boolean isEnglish(String str) {
		for (char c : str.toCharArray()) {
			if (c > '\u007F') {
				// ASCII range for English
				return false;
			}
		}
		return true;
	}

	public static boolean isArabic(String str) {
		for (char c : str.toCharArray()) {
			if (c >= '\u0600' && c <= '\u06FF') {
				// Unicode range for Arabic script
				return true;
			}
		}
		return false;
	}
}

