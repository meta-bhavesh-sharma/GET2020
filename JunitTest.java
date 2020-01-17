package Assignment4;

import java.util.*;

public class JunitTest {
	/**
	 * method to find largest mirror of intiger array
	 * 
	 * 
	 * @param arr
	 *            input intiger array
	 * @param n
	 *            size of array
	 * @return intiger denotes maximum length of mirror
	 */
	public static int largestMirror(int[] arr, int n) {
		int count = 0;
		int max = 0;
		int k = 0;
		for (int i = 0; i < n; i++) {
			k = i;
			count = 0;
			for (int j = n - 1; j >= 0; j--) {
				if (arr[k] == arr[j]) {
					if (k == n - 1) {
						count++;
						if (max < count) {
							max = count;
							count = 0;
						}
						break;
					}
					count++;
					k++;
					continue;
				} else if (count != 0) {
					if (max < count)
						max = count;
					count = 0;
					k = i;
				}
			}
			if (n - i - 1 <= max)
				break;
			if (count > max) {
				max = count;
				count = 0;
			}
		}
		return max;
	}

	/**
	 * method to find maximum clump
	 * 
	 * @param arr
	 *            input intiger array
	 * @param n
	 *            size of array
	 * @return intiger denotes mximum number of clumps present
	 */
	public int clump(int[] arr, int n) {
		int count = 0;
		int clump = 0;
		for (int i = 0; i < n - 1; i++) {
			if (arr[i] == arr[i + 1])
				count++;
			else if (arr[i] != arr[i + 1] && count != 0) {
				count = 0;
				clump++;
			}
			if (arr[i] == arr[i + 1] && (i + 1) == n - 1) {
				clump++;
			}
		}
		return clump;
	}

	/**
	 * method of xy shift place y adjsent to x without moving x
	 * 
	 * @param arr
	 *            input integer array
	 * @param x
	 *            value of x which will not move
	 * @param y
	 *            which will move,swap
	 * @param n
	 * @return
	 */
	public int[] fixXY(int[] arr, int x, int y, int n) {
		if (arr == null || arr.length == 0)
			return null;
		ArrayList<Integer> xin = new ArrayList<Integer>(1);
		ArrayList<Integer> yin = new ArrayList<Integer>(1);
		for (int i = 0; i < n; i++) {
			if (arr[i] == x)
				xin.add(i);
			if (arr[i] == y)
				yin.add(i);
			if (xin.get(i) == n - 1)
				return null;
			if (xin.get(i) == xin.get(i - 1))
				return null;
		}
		if (xin.size() != yin.size())
			return null;
		for (int i = 0; i < yin.size(); i++) {
			int temp;
			temp = arr[yin.get(i)];
			arr[yin.get(i)] = arr[xin.get(i) + 1];
			arr[xin.get(i) + 1] = temp;
		}

		return arr;
	}

	/**
	 * method to find index of array by which array could be divided into 2
	 * equal parts having sum of elements is equal
	 * 
	 * @param arr
	 *            input array
	 * @param n
	 *            size
	 * @return integer denotes that index
	 */
	public int split(int[] arr, int n) {
		int splitin = -1;
		int sum = 0;
		int sum2 = 0;
		for (int i = 0; i < n; i++) {
			sum = sum + arr[i];
		}
		if (sum % 2 != 0)
			return splitin;
		for (int i = 0; i < n; i++) {
			sum2 = sum2 + arr[i];
			if (sum2 == (sum / 2)) {
				splitin = i;
				return splitin + 1;
			}
		}
		return splitin;
	}
}
