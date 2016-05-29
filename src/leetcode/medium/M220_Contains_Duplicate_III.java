package leetcode.medium;

import java.util.SortedSet;
import java.util.TreeSet;

public class M220_Contains_Duplicate_III {

	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		// input check
		if (k < 1 || t < 0 || nums == null || nums.length < 2)
			return false;

		SortedSet<Long> set = new TreeSet<Long>();

		for (int j = 0; j < nums.length; j++) {
			SortedSet<Long> subSet = set.subSet((long) nums[j] - t, (long) nums[j] + t + 1);
			if (!subSet.isEmpty())
				return true;

			if (j >= k) {
				set.remove((long) nums[j - k]);
			}
			set.add((long) nums[j]);
		}
		return false;
	}
}
