package leetcode.medium;

public class M35_Search_Insert_Position {
	public int searchInsert(int[] nums, int target) {
		int low = 0;
		int high = nums.length - 1;
		if (nums[low] > target)
			return low;
		if (nums[high] < target)
			return high + 1;

		while (low <= high) {
			//Note:  ((h-l)>>1)
			int mid = low + ((high - low) >> 1);
			if (nums[mid] < target) {
				low = mid + 1;
				if (nums[low] > target) {
					return low;
				}
			} else if (nums[mid] > target) {
				high = mid - 1;
				if (nums[high] < target)
					return high + 1;
			} else
				return mid;
		}

		return 0;
	}
	
	public static void main(String[] args) {
		new M35_Search_Insert_Position().searchInsert(new int[]{1,2}, 2);
		
		System.out.println(0>>1);
	}
}
