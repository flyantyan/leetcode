package leetcode.medium;

import java.util.Arrays;

public class M137_Single_Number_II {

	public int singleNumber(int[] nums) {
		Arrays.sort(nums);
		int i = 0;
		for (; i < nums.length - 2;) {
			if (nums[i] == nums[i + 1] && nums[i] == nums[i + 2])
				i += 3;
			else
				return nums[i];
		}
		return nums[i];
	}
}
