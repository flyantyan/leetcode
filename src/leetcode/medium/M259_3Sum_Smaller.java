package leetcode.medium;

import java.util.Arrays;

public class M259_3Sum_Smaller {

	public int threeSumSmaller(int[] nums, int target) {
		if (nums == null || nums.length < 3)
			return 0;

		Arrays.sort(nums);
		int count = 0;
		for (int i = 0; i < nums.length - 2; i++) {
			int low = i + 1;
			int high = nums.length - 1;

			while (low < high) {
				if (nums[i] + nums[low] + nums[high] < target) {
					count += (high - low);
					low++;
				} else {
					high--;
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		new M259_3Sum_Smaller().threeSumSmaller(new int[] { 3, 1, 0, -2 }, 4);
	}
}
