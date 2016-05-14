package leetcode.medium;

public class M153_Find_Minimum_in_Rotated_Sorted_Array {

	public int findMin(int[] nums) {
		int low = 0;
		int high = nums.length - 1;

		while (low < high) {
			int mid = low + (high - low) / 2;
			if (nums[mid] < nums[high])
				high = mid;
			else if (nums[mid] > nums[high]) {
				low = mid + 1;
			}

		}

		return nums[low];
	}
}
