package leetcode.easy;

public class E303_Range_Sum_Query_Immutable {

	int[] nums;

	public E303_Range_Sum_Query_Immutable(int[] nums) {
		for (int i = 1; i < nums.length; i++)
			nums[i] += nums[i - 1];

		this.nums = nums;
	}

	public int sumRange(int i, int j) {
		if (i == 0)
			return nums[j];

		return nums[j] - nums[i - 1];
	}
}
