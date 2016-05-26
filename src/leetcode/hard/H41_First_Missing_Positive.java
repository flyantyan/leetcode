package leetcode.hard;

import java.util.Arrays;

public class H41_First_Missing_Positive {

	public int firstMissingPositive(int[] A) {
		int i = 0;
		while (i < A.length) {
			if (A[i] == i + 1 || A[i] <= 0 || A[i] > A.length)
				i++;
			else if (A[A[i] - 1] != A[i])
				swap(A, i, A[i] - 1);
			else
				i++;
		}
		i = 0;
		while (i < A.length && A[i] == i + 1)
			i++;
		return i + 1;
	}

	private void swap(int[] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}

	public int firstMissingPositive_1(int[] nums) {
		if (nums == null || nums.length == 0)
			return 1;
		Arrays.sort(nums);
		int num = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] <= 0) {
				continue;
			} else if (nums[i] == num + 1 || (i >= 1 && nums[i] == nums[i - 1])) {
				num = nums[i];
			} else {
				return num + 1;
			}
		}
		return num + 1;
	}

	public static void main(String[] args) {
		new H41_First_Missing_Positive().firstMissingPositive(new int[] { 0, -1, -4, -2, -4, 0, 2, 1 });
	}
}
