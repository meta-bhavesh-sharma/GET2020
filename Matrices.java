import java.util.*;

/**
 * Matrices class made to perform effective operations on parse matrices
 * 
 * @author Bhavesh Sharma
 *
 */
public class Matrices {
	ArrayList<Element> list = new ArrayList<Element>();
	int order;

	/**
	 * 
	 * @param e array containing elements
	 * @param i array containing row
	 * @param j array containing columns
	 * @param n order of matrices
	 */
	Matrices(int[] e, int[] i, int[] j, int n) {
		for (int k = 0; k < e.length; k++) {
			list.add(new Element(e[k], i[k], j[k]));
		}
		order = n;
	}

	/**
	 * 
	 * @return Matrices object having traspose parse matrices
	 */
	Matrices transpose() {
		int[] e = new int[list.size()];
		int[] i = new int[list.size()];
		int[] j = new int[list.size()];
		for (int k = 0; k < list.size(); k++) {
			e[k] = list.get(k).element;
			i[k] = list.get(k).raw;
			j[k] = list.get(k).column;

		}
		return new Matrices(e, i, j, order);

	}

	/**
	 * 
	 * @return 2 dimentional array containing matrices of parse matrices
	 */
	int[][] getMetrices() {
		int[][] arr = new int[order][order];
		for (int i = 0; i < order; i++) {
			arr[list.get(i).raw][list.get(i).column] = list.get(i).element;
		}
		return arr;
	}

	/**
	 * 
	 * @return boolean if matrices is symmetric or not
	 */
	boolean isSymmetric() {
		Matrices m = this.transpose();
		for (int k = 0; k < list.size(); k++) {
			if (!(list.get(k).element == m.list.get(k).element && list.get(k).raw == m.list.get(k).raw
					&& list.get(k).column == m.list.get(k).column))
				return false;
		}
		return true;
	}

	/**
	 * 
	 * @param m1 matrices 1 operend 1
	 * @param m2 matrices 2 operend 2
	 * @return 2 dimentional array represent addtion of those 2 parse matrices
	 */
	int[][] add(Matrices m1, Matrices m2) {
		int[][] arr = new int[order][order];
		System.out.println(m1.list.size());
		for (int k = 0; k < m1.list.size(); k++) {
			arr[m1.list.get(k).raw][m1.list.get(k).column] += m1.list.get(k).element;
		}
		for (int k = 0; k < m2.list.size(); k++) {
			arr[m2.list.get(k).raw][m2.list.get(k).column] += m2.list.get(k).element;
		}
		return arr;
	}

	/**
	 * 
	 * @param m1 matrices 1 operend 1
	 * @param m2 matrices 2 operend 2
	 * @return 2 dimentional array represent multiplication of those 2 parse
	 *         matrices
	 */
	int[][] multiMatrices(Matrices m1, Matrices m2) {
		int a[][] = new int[order][order];
		int b[][] = new int[order][order];
		int c[][] = new int[order][order];
		for (int k = 0; k < m1.list.size(); k++) {
			a[m1.list.get(k).raw][m1.list.get(k).column] += m1.list.get(k).element;
		}
		for (int k = 0; k < m2.list.size(); k++) {
			b[m2.list.get(k).raw][m2.list.get(k).column] += m2.list.get(k).element;
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				c[i][j] = 0;
				for (int k = 0; k < 3; k++) {
					c[i][j] += a[i][k] * b[k][j];
				}
			}
		}
		return c;
	}
//Driver code
	public static void main(String args[]) {
		int raw1[] = { 0, 1, 2 };
		int column1[] = { 0, 1, 2 };
		int element1[] = { 1, 1, 1 };
		int raw2[] = { 2, 1, 0 };
		int column2[] = { 0, 1, 2 };
		int element2[] = { 1, 1, 1 };
		int[][] arr = new int[3][3];
		Matrices m1 = new Matrices(element1, raw1, column1, 3);
		Matrices m2 = new Matrices(element2, raw2, column2, 3);
		arr = m1.multiMatrices(m1, m2);
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

}
