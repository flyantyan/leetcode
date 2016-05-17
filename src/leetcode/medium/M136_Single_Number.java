package leetcode.medium;

public class M136_Single_Number {

	public int singleNumber(int[] nums) {
		if (nums == null)
			return 0;
		int result = nums[0];
		for (int i = 1; i < nums.length; i++) {
			result ^= nums[i];
		}

		return result;
	}
}
