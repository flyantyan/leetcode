package leetcode.medium;

public class M213_House_Robber_II {

	public int rob(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		if (nums.length == 1)
			return nums[0];
		return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
	}

	private int rob(int[] num, int lo, int hi) {
		int include = 0, exclude = 0;
		for (int j = lo; j <= hi; j++) {
			int i = include, e = exclude;
			include = e + num[j];
			exclude = Math.max(e, i);
		}
		return Math.max(include, exclude);
	}

}
