package Assignment3;

import java.util.*;

class StringOp {
	static boolean stringComparison(String s1, String s2) {
		if (s1.length() == s2.length()) {
			for (int i = 0; i < s1.length(); i++) {
				if (s1.charAt(i) == s2.charAt(i))
					continue;
				else
					return false;
			}
			return true;
		} else {
			return false;
		}
	}

	static String stringReverse(String s1) {
		char[] c2 = new char[s1.length()];
		for (int i = 0; i < s1.length(); i++) {
			c2[i] = s1.charAt(s1.length() - 1 - i);
		}
		return new String(c2);
	}

	static String reverseCase(String s1) {
		char[] c2 = new char[s1.length()];
		for (int i = 0; i < s1.length(); i++) {
			c2[i] = s1.charAt(s1.length() - 1 - i);
			if (65 <= c2[i] && c2[i] <= 91) {
				c2[i] = (char) ((int) c2[i] + 32);
			} else if (97 <= c2[i] && c2[i] <= 122) {
				c2[i] = (char) ((int) c2[i] - 32);
			}
		}
		return new String(c2);
	}

	static String stringLongest(String s1) {
		int i;
		int j = 1;
		int[] a = new int[s1.length()];
		a[0] = 0;
		for (i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) == ' ' || s1.charAt(i) == s1.length() - 1) {
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
			if ((a[i] - a[i - 1]) >= d && a[i] == s1.length() - 1) {
				d = a[i] - a[i - 1] + 1;
				index = a[i - 1];
			}
		}
		char[] c = s1.toCharArray();
		return new String(c, index, d + 1);
	}

}