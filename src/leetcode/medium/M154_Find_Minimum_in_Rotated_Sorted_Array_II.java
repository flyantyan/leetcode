package leetcode.medium;

public class M154_Find_Minimum_in_Rotated_Sorted_Array_II {

	public int findMin(int[] nums) {
		int low = 0;
		int high = nums.length - 1;
		while (low < high) {
			int mid = low + (high - low) / 2;

			if (nums[mid] > nums[high]) {
				low = mid + 1;
			} else if (nums[mid] < nums[high]) {
				high = mid;
			} else {
				high--;
			}
		}

		return nums[low];
	}
}
