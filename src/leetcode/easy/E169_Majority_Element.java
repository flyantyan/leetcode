package leetcode.easy;

import java.util.Arrays;

public class E169_Majority_Element {

	public int majorityElement(int[] nums) {
		int major = nums[0];
		int count = 1;
		for (int i = 1; i < nums.length; i++) {

			if (count == 0) {
				count++;
				major = nums[i];
			} else if (major == nums[i]) {
				count++;
			} else {
				count--;
			}

		}
		return major;
	}

	public int majorityElement_1(int[] nums) {
		Arrays.sort(nums);
		return nums[nums.length / 2];
	}
}
