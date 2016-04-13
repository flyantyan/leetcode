package leetcode.medium;

import java.util.Arrays;

public class M16_3Sum_Closest {
	public int threeSumClosest(int[] nums, int target) {
		if (nums == null || nums.length < 3) {
			return 0;
		}
		Arrays.sort(nums);
		int sum = nums[0] + nums[1] + nums[nums.length - 1];
		int result = Math.abs(sum - target);

		for (int i = 0; i < nums.length - 2; i++) {
			int start = i + 1;
			int end = nums.length - 1;
			while (start < end) {
				int currentSum = nums[i] + nums[start] + nums[end];
				if (currentSum == target)
					return currentSum;
				else if (currentSum < target) {
					while (start < end && nums[start] == nums[start + 1])
						start++;
					start++;
				} else {
					while (start < end && nums[end - 1] == nums[end])
						end--;
					end--;
				}
				if (Math.abs(currentSum - target) < result) {
					result = Math.abs(currentSum - target);
					sum = currentSum;
				}
			}
		}

		return sum;
	}
	
	public static void main(String[] args) {
		int i = new M16_3Sum_Closest().threeSumClosest(new int[]{-10,0,-2,3,-8,1,-10,8,-8,6,-7,0,-7,2,2,-5,-8,1,-4,6}, 18);
		System.out.println(i);
	}
}
