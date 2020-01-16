package Assignment3;

import java.util.*;

class Marksheet {
	double findAvg(int n, int[] st) {
		double sum = 0;
		for (int i = 0; i < n; i++) {
			sum = sum + st[i];
		}
		return sum / n;
	}

	int findMax(int n, int[] st) {
		int max = 0;
		for (int i = 0; i < n; i++) {
			if (st[i] > max) {
				max = st[i];
			}
		}
		return max;
	}

	int findMin(int n, int[] st) {
		int min = 100;
		for (int i = 0; i < n; i++) {
			if (st[i] < min) {
				min = st[i];
			}
		}
		return min;
	}

	double findPassPercent(int n, int[] st) {
		double count = 0;
		for (int i = 0; i < n; i++) {
			if (st[i] >= 40) {
				count++;
			}
		}
		return count / n * 100;
	}

}
