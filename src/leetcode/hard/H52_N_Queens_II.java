package leetcode.hard;

public class H52_N_Queens_II {
	// Reference http://blog.csdn.net/feliciafay/article/details/44058621
	public int totalNQueens(int n) {
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i;
		}
		genNQueens(arr, 0, n);
		return sum;
	}

	private int sum = 0;

	private void genNQueens(int arr[], int k, int n) {
		if (k == n) {
			sum++;
			return;
		}
		for (int i = k; i < n; i++) {
			swap(arr, i, k);
			if (!collide(k, arr)) {
				genNQueens(arr, k + 1, n);
			}
			swap(arr, i, k);
		}
	}

	boolean collide(int k, int[] array) {
		for (int i = 0; i < k; ++i) {
			// 检查array[k] 和 array[k]之前的数有无对角线方向的冲突
			if ((array[k] - k == array[i] - i) || (array[k] + k == array[i] + i))
				return true;
		}
		return false;
	}

	private void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
