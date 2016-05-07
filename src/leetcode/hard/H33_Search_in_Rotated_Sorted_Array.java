package leetcode.hard;

public class H33_Search_in_Rotated_Sorted_Array {
	public int search(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;

		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] == target)
				return mid;
			if (nums[mid] < nums[right]) {
				if (nums[mid] < target && nums[right] >= target) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			} else {
				if (target >= nums[left] && target < nums[mid]) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		new H33_Search_in_Rotated_Sorted_Array().search(new int[] { 3, 5, 0 }, 3);
	}
}
