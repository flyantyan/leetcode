package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class M229_Majority_Element_II {

	public List<Integer> majorityElement(int[] nums) {
		List<Integer> result = new ArrayList<>();
		if (nums == null || nums.length == 0)
			return result;
		int m = 0, n = 0, cm = 0, cn = 0;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == m) {
				cm++;
			} else if (nums[i] == n) {
				cn++;
			} else if (cm == 0) {
				cm = 1;
				m = nums[i];
			} else if (cn == 0) {
				cn = 1;
				n = nums[i];
			} else {
				cn--;
				cm--;
			}
		}

		cm = 0;
		cn = 0;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == m) {
				cm++;
			} else if (nums[i] == n) {
				cn++;
			}
		}

		if (cm > nums.length / 3)
			result.add(m);

		if (cn > nums.length / 3)
			result.add(n);

		return result;
	}
}
