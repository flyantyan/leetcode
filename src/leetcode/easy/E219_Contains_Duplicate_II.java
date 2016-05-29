package leetcode.easy;

import java.util.HashMap;

public class E219_Contains_Duplicate_II {
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		if (nums == null || k < 0)
			return false;
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i]) && Math.abs(i - map.get(nums[i])) <= k) {
				return true;
			}
			map.put(nums[i], i);
		}
		return false;
	}
}
