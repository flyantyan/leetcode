package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class M228_Summary_Ranges {

	public List<String> summaryRanges(int[] nums) {
		List<String> result = new ArrayList<>();
		if (nums == null)
			return result;

		for (int i = 0; i < nums.length; i++) {
			int left = nums[i];
			while (i + 1 < nums.length && nums[i] + 1 == nums[i + 1]) {
				i++;
			}
			if (left != nums[i])
				result.add(left + "->" + nums[i]);
			else
				result.add(left + "");
		}
		return result;
	}
}
