package Assignment3;

import java.util.*;

class StringOp {
	/**
	 * 
	 * @param str1 input string 1
	 * @param str2 input string 2
	 * @return boolean if equals true else false
	 */
	static boolean stringComparison(String str1, String str2) {
		if (str1.length() == str2.length()) {
			for (int i = 0; i < str1.length(); i++) {
				if (str1.charAt(i) == str2.charAt(i))
					continue;
				else
					return false;
			}
			return true;
		} else {
			return false;
		}
	}
	/**
	 * 
	 * @param str1 str1 input string 1
	 * @return reverse string
	 */
	static String stringReverse(String str1) {
		char[] c2 = new char[str1.length()];
		for (int i = 0; i < str1.length(); i++) {
			c2[i] = str1.charAt(str1.length() - 1 - i);
		}
		return new String(c2);
	}
	/**
	 * 
	 * @param str1 str1 input string 1
	 * @return string with change case
	 */
	static String reverseCase(String str1) {
		char[] c2 = new char[str1.length()];
		for (int i = 0; i < str1.length(); i++) {
			c2[i] = str1.charAt(str1.length() - 1 - i);
			if (65 <= c2[i] && c2[i] <= 91) {
				c2[i] = (char) ((int) c2[i] + 32);
			} else if (97 <= c2[i] && c2[i] <= 122) {
				c2[i] = (char) ((int) c2[i] - 32);
			}
		}
		return new String(c2);
	}
/**
 * 
 * @param str1 str1 input string 1
 * @return longest word in string
 */
	static String stringLongest(String str1) {
		int i;
		int j = 1;
		int[] a = new int[str1.length()];
		a[0] = 0;
		for (i = 0; i < str1.length(); i++) {
			if (str1.charAt(i) == ' ' || str1.charAt(i) == str1.length() - 1) {
				a[j] = i;
				j++;
			}
		}
		int d = 0;
		int index = 0;
		for (i = 1; a[i] != 0; i++) {
			if ((a[i] - a[i - 1]) >= d) {
				d = a[i] - a[i - 1];
				index = a[i];
			}
			if ((a[i] - a[i - 1]) >= d && a[i] == str1.length() - 1) {
				d = a[i] - a[i - 1] + 1;
				index = a[i - 1];
			}
		}
		char[] c = str1.toCharArray();
		return new String(c, index, d + 1);
	}

}