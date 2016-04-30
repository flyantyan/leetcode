package leetcode.medium;

public class M53_Maximum_Subarray {
	public int maxSubArray(int[] nums) {
		/*
		 * Basic idea: Keep an integer currentsum to keep track of the current
		 * summation Keep another integer maxsum to keep track of the maximum
		 * summation till now However, if currentsum ≤ 0; then a maximum cannot
		 * be generated under current condition (since a negative number plus
		 * any number is always less than that number), so we let the currentsum
		 * to be 0 (simply drop before result) under this condition and
		 * recalculate the summation again from 0 and current position.
		 * Otherwise, currentsum is the summation of previous currentsum and
		 * number of current position Then we renew the maximum summation
		 */
		if (nums == null) {
			return 0;
		}
		int length = nums.length;
		if (length == 1) {
			return nums[0];
		}
		int currentsum = nums[0];
		int maxsum = nums[0];
		for (int i = 1; i < length; i++) {
			if (currentsum >= 0) {
				currentsum += nums[i];
			}

			else {
				currentsum = nums[i];
			}

			maxsum = maxsum > currentsum ? maxsum : currentsum;
		}

		return maxsum;
	}
}
