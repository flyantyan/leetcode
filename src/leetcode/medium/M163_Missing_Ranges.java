package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class M163_Missing_Ranges {

	public List<String> findMissingRanges(int[] nums, int lower, int upper) {
		List<String> result = new ArrayList<>();
		if (nums == null || nums.length == 0) {
			result.add(getRange(lower, upper));
			return result;
		}

		int next = lower;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] < next)
				continue;
			if (nums[i] == next) {
				next++;
				continue;
			}

			result.add(getRange(next, nums[i] - 1));
			next = nums[i] + 1;
		}
		if (next <= upper)
			result.add(getRange(next, upper));

		return result;
	}

	private String getRange(int low, int high) {
		return (low == high) ? low + "" : low + "->" + high;
	}
}
