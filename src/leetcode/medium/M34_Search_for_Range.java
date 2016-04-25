package leetcode.medium;

public class M34_Search_for_Range {

	public static int indexOf(int[] a, int key) {
		int lo = 0;
		int hi = a.length - 1;
		int mid = 0 ;
		while (lo <= hi) {
			// Key is in a[lo..hi] or not present.
			 mid = lo + (hi - lo) / 2;
			if (key < a[mid])
				hi = mid - 1;
			else if (key > a[mid])
				lo = mid + 1;
			else
				return mid;
		}
		return -1;
	}

	public int[] searchRange(int[] nums, int target) {
		int start = 0;
		int end = nums.length - 1;
		int mid = 0;
		while (start <= end) {
			 mid = start + ((end - start) >> 1);
			if (nums[mid] < target) {
				start = mid + 1;
			} else if (nums[mid] > target) {
				end = mid - 1;
			} else
				break;
		}

		if (nums[mid] != target) {
			return new int[] { -1, -1 };
		}

		start = mid;
		end = mid;
		while (start >= 0 && nums[start] == target)
			start--;

		while (end < nums.length && nums[end] == target)
			end++;

		return new int[] { start + 1, end - 1 };
	}

	public static void main(String[] args) {
//		new M34_Search_for_Range().searchRange(new int[] { 2, 2 }, 1);
		
//		int i = indexOf(new int[]{1,1}, 2);
//		System.out.println(i);
	}
}
