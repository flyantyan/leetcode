package leetcode.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class E217_Contains_Duplicate {

	public boolean containsDuplicate(int[] nums) {

		Arrays.sort(nums);
		for (int ind = 1; ind < nums.length; ind++) {
			if (nums[ind] == nums[ind - 1]) {
				return true;
			}
		}
		return false;
	}

	public boolean containsDuplicate_1(int[] nums) {
		final Set<Integer> set = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			if (set.contains(nums[i]))
				return true;
			set.add(nums[i]);
		}

		return false;
	}
}
