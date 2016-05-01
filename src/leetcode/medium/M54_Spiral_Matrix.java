package leetcode.medium;

import java.util.LinkedList;
import java.util.List;

/*
 * TestCase :
 * 	
 * 			[[6,9,7]]
 * 			[[7],[9],[6]]
 */
public class M54_Spiral_Matrix {
	// public List<Integer> spiralOrder(int[][] arr) {
	// List<Integer> result = new ArrayList<Integer>();
	// if (arr == null || arr.length == 0 || arr[0].length == 0)
	// return result;
	// int m = arr.length - 1;
	// int n = arr[0].length - 1;
	//
	// for (int i = 0; i <= (m + 1) / 2; i++) {
	// for (int j = i; j < n - i; j++) {
	// result.add(arr[i][j]);
	// }
	// for (int j = i; j < m - i && n-i >= 0; j++) {
	// result.add(arr[j][n - i]);
	// }
	//
	// for (int j = n - i ; j > i; j--) {
	// result.add(arr[m - i][j]);
	// }
	// for (int j = m - i; j > i; j--) {
	// result.add(arr[j][i]);
	// }
	// }
	//
	// return result;
	// }
	//

	public List<Integer> spiralOrder(int[][] mtx) {
		List<Integer> ret = new LinkedList<>();
		if (mtx.length == 0)
			return ret;
		int m = mtx.length;
		int n = mtx[0].length;
		int min = Math.min(m, n);
		for (int i = 0; i < Math.ceil(min / 2.); i++) {
			for (int j = i; j < n - i; j++)
				ret.add(mtx[i][j]);
			for (int j = i + 1; j < m - i; j++)
				ret.add(mtx[j][n - i - 1]);
			if (i != m - i - 1)
				for (int j = n - i - 2; j >= i; j--)
					ret.add(mtx[m - i - 1][j]);
			if (n - i - 1 != i)
				for (int j = m - i - 2; j > i; j--)
					ret.add(mtx[j][i]);
		}
		return ret;
	}

	public static void main(String[] args) {
		new M54_Spiral_Matrix().spiralOrder(new int[][] { { 1 }, { 2 }, { 3 } });
	}

}
