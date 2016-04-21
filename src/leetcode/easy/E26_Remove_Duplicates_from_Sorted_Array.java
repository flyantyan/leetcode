package leetcode.easy;

public class E26_Remove_Duplicates_from_Sorted_Array {
	public int removeDuplicates(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;

		int start = 0;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == nums[i - 1]) {
				continue;
			} else {
				nums[++start] = nums[i];
			}
		}
		return start + 1;
	}

	public int removeDuplicates2(int[] nums) {
		int i = 0;
		for (int n : nums)
			if (i == 0 || n > nums[i - 1])
				nums[i++] = n;
		return i;
	}
}
