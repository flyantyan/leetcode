package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class M46_Permutations {
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		helper(nums, new ArrayList<Integer>(), res);
		return res;
	}

	private void helper(int[] nums, List<Integer> item, List<List<Integer>> res) {
		// base case
		if (item.size() == nums.length) {
			res.add(new ArrayList<Integer>(item));
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			if (isValidFill(item, nums[i])) {
				helper(nums, item, res);
				item.remove(item.size() - 1);
			}
		}
	}

	private boolean isValidFill(List<Integer> item, int element) {
		if (!item.contains(element)) {
			item.add(element);
			return true;
		}
		return false;
	}
}
