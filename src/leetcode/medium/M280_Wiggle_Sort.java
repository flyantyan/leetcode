package leetcode.medium;

import java.util.Arrays;

public class M280_Wiggle_Sort {

	public void wiggleSort(int[] nums) {
		if (nums == null || nums.length == 0)
			return;

		Arrays.sort(nums);

		int[] temp = new int[nums.length];
		int mid = (nums.length + 1) >> 1;
		int end = nums.length;

		for (int i = 0; i < nums.length; i++) {
			// 4 5 5 6
			temp[i] = (i & 1) == 0 ? nums[--mid] : nums[--end];
		}

		for (int i = 0; i < nums.length; i++) {
			nums[i] = temp[i];
		}
	}
}
