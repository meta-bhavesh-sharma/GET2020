package Assignment3;

import java.util.*;

class Marksheet {
	/**
	 * 
	 * @param n number of students
	 * @param st array of students grades
	 * @return average marks
	 */
	double findAvg(int n, int[] st) {
		double sum = 0;
		for (int i = 0; i < n; i++) {
			sum = sum + st[i];
		}
		return sum / n;
	}
	/**
	 * 
	 * @param n number of students
	 * @param st array of students grades
	 * @return maximum marks
	 */
	int findMax(int n, int[] st) {
		int max = 0;
		for (int i = 0; i < n; i++) {
			if (st[i] > max) {
				max = st[i];
			}
		}
		return max;
	}
	/**
	 * 
	 * @param n number of students
	 * @param st array of students grades
	 * @return minimum marks
	 */
	int findMin(int n, int[] st) {
		int min = 100;
		for (int i = 0; i < n; i++) {
			if (st[i] < min) {
				min = st[i];
			}
		}
		return min;
	}
	/**
	 * 
	 * @param n number of students
	 * @param st array of students grades
	 * @return percentage of student passed
	 */
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
