package leetcode.easy;

public class E27_Remove_Element {

	public int removeElement1(int[] nums, int val) {
		int current = 0;
		for (int n : nums) {
			if (n != val)
				nums[current++] = n;
		}
		return current;
	}

	//类似于快速排序
	public int removeElement(int[] nums, int val) {
		if (nums == null)
			return 0;
		int start = 0;
		int end = nums.length - 1;

		while (start <= end) {
			if (nums[start] == val) {
				nums[start] = nums[end--];
			} else {
				start++;
			}
		}

		return end + 1;
	}
}
