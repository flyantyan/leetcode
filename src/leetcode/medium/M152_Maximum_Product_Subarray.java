package leetcode.medium;

public class M152_Maximum_Product_Subarray {

	public int maxProduct(int[] nums) {
		if (nums == null)
			return 0;

		int maxHere = nums[0];
		int minHere = nums[0];
		int maxSoFar = nums[0];
		int maxPre = nums[0];
		int minPre = nums[0];
		for (int i = 1; i < nums.length; i++) {
			maxHere = Math.max(Math.max(maxPre * nums[i], minPre * nums[i]), nums[i]);
			minHere = Math.min(Math.min(maxPre * nums[i], minPre * nums[i]), nums[i]);
			maxSoFar = Math.max(maxHere, maxSoFar);
			maxPre = maxHere;
			minPre = minHere;
		}

		return maxSoFar;

	}
}
