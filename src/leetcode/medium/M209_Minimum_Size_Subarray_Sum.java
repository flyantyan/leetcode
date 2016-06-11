package leetcode.medium;

public class M209_Minimum_Size_Subarray_Sum {

	//使用两个指针，一前一后形成一个窗口，start end 
	//end 后移直到sum > s
	//start 后移直到 sum < s  此时可以计算 窗口大小
	public int minSubArrayLen(int s, int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;

		int min = Integer.MAX_VALUE;

		int start = 0;
		int end = 0;
		int sum = 0;

		while (start < nums.length && end < nums.length) {
			while (sum < s && end < nums.length) {
				sum += nums[end++];
			}
			while (sum >= s && start < nums.length) {
				min = Math.min(end - start, min);
				sum -= nums[start++];
			}
		}
		return min == Integer.MAX_VALUE ? 0 : min;
	}
}
