package leetcode.medium;

public class M268_Missing_Number {

	public int missingNumber(int[] nums) {

		int xor = 0, i = 0;
		for (i = 0; i < nums.length; i++) {
			xor = xor ^ i ^ nums[i];
		}

		return xor ^ i;
	}

	public int missingNumber_2(int[] nums) {
		if (nums == null) {
			return 0;
		}
		int num = 0;
		for (int i = 0; i < nums.length; i++) {
			num = i + 1 - nums[i] + num;
		}

		return num;
	}

	public int missingNumber_1(int[] nums) {
		// 1.Calculate the sum of the arrays sum1
		// 2.Calculate the sum of the arrays and the miss one sum2(sum =
		// n(n+1)/2 n is the length of the array)
		// 3. sum2-sum1 should be the missed one
		if (nums == null) {
			return 0;
		}
		int sum1 = 0;
		int len = nums.length;
		for (int i = 0; i < nums.length; i++) {
			sum1 += nums[i];
		}
		// the opt will overflow when len is large
		return len * (len + 1) / 2 - sum1;
	}
}
