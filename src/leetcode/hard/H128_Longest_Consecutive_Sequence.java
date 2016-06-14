package leetcode.hard;

import java.util.Arrays;

public class H128_Longest_Consecutive_Sequence {
	public int longestConsecutive(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		Arrays.sort(nums);

		int count = 1;
		int max = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == nums[i - 1] + 1) {
				count++;
			} else if (nums[i - 1] == nums[i]) {
				continue;
			} else {
				max = Math.max(max, count);
				count = 1;
			}
		}

		return Math.max(max, count);
	}

	public static void main(String[] args) {
		new H128_Longest_Consecutive_Sequence().longestConsecutive(new int[] { 0, -1 });
	}
}
