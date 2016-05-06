package leetcode.medium;

import java.util.HashMap;

public class M80_Remove_Duplicates_from_Sorted_ArrayII {

	public int removeDuplicates1(int[] nums) {
		int i = 0;
		for (int n : nums)
			if (i < 2 || n > nums[i - 2])
				nums[i++] = n;
		return i;
	}

	//影响了数组的原有顺序
	public int removeDuplicates(int[] nums) {
		HashMap<Integer, Integer> map = new HashMap<>();

		int i = 0;
		int end = nums.length - 1;
		while (i <= end) {

			if (map.containsKey(nums[i])) {
				int count = map.get(nums[i]);
				if (count != 2)
					map.put(nums[i], count + 1);
				else {
					// Swap current num to the end of array
					int temp = nums[i];
					nums[i] = nums[end];
					nums[end--] = temp;
					continue;
				}

			} else {
				map.put(nums[i], 1);
			}

			i++;
		}
		return end;
	}

	public static void main(String[] args) {
		new M80_Remove_Duplicates_from_Sorted_ArrayII()
				.removeDuplicates(new int[] { 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2 });
	}
}
