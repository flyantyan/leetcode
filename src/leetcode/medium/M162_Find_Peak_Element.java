package leetcode.medium;

public class M162_Find_Peak_Element {

	public int findPeakElement(int[] nums) {
		if (nums == null || nums.length == 0)
			return -1;
		if (nums.length == 1)
			return 0;

		for (int i = 0; i < nums.length; i++) {
			if (i == 0)
				if (nums[i] > nums[i + 1])
					return 0;
				else
					continue;
			if (i == nums.length - 1)
				if (nums[i] > nums[i - 1])
					return i;
				else
					continue;
			if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1])
				return i;
		}
		return -1;
	}
}
