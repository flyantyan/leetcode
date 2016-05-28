package leetcode.hard;

import java.util.ArrayList;
import java.util.List;

public class H51_N_Queens {

	public List<List<String>> solveNQueens(int n) {
		List<List<String>> result = new ArrayList<>();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = i;
		}
		genNQueens(0, n, result, arr);

		return result;
	}

	private void genNQueens(int k, int n, List<List<String>> result, int[] arr) {
		if (k == n) {
			List<String> r = new ArrayList<>();
			for (int i = 0; i < arr.length; i++) {
				StringBuilder sb = new StringBuilder();
				for (int j = 0; j < arr.length; j++) {
					if (j == arr[i]) {
						sb.append("Q");
					} else {
						sb.append(".");
					}
				}
				r.add(sb.toString());
			}
			result.add(r);
			return;
		}

		for (int i = k; i < n; i++) {
			swap(arr, k, i);
			if (!collide(arr, k)) {
				genNQueens(k + 1, n, result, arr);
			}
			swap(arr, k, i);
		}
	}

	private boolean collide(int arr[], int k) {
		for (int i = 0; i < k; i++) {
			if (arr[k] - k == arr[i] - i || arr[k] + k == arr[i] + i)
				return true;
		}
		return false;
	}

	private void swap(int arr[], int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
