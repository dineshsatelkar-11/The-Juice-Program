package com.questionpro.test;
import java.util.HashSet;
import java.util.Set;

public class Validator {

	public static boolean isNumeric(String strNum, String status) {
		if (strNum == null) {
			return false;
		}
		try {
			double d = Double.parseDouble(strNum);
			switch (status) {
			case Constant.NO_OF_FRIENDS:
				if (0 < d && d < 201) {
					return true;
				}
			case Constant.NO_OF_UNIQUE_JUICE:
				if (0 < d && d < 27) {
					return true;
				}
			case Constant.CHECK_NO_ONLY:
				return true;
			case Constant.CHECK_NO_ONLY_FOR_INPUT_TYPE:
				if (0 < d && d < 3) {
					return true;
				}

			}
		} catch (NumberFormatException nfe) {
			return false;
		}
		return false;
	}

	public static boolean validateCalories(String[] cal, int noofuniqueJuice) {
		if (cal.length != noofuniqueJuice) {
			return false;
		}
		for (String w : cal) {
			if (!isNumeric(w, Constant.CHECK_NO_ONLY)) {
				return false;
			}
		}
		return true;
	}

	public static boolean validateJuices(String juicesincupboard, int noofuniqueJuice) {
		Set<String> hash_Set = new HashSet<String>();
		char[] charArray = juicesincupboard.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			// if any character is not in lower case, return false
			if (!Character.isLowerCase(charArray[i]))
				return false;
			hash_Set.add(Character.toString(charArray[i]));
		}
		if (hash_Set.size() != noofuniqueJuice) {
			return false;
		}
		return true;
	}

}
