package leetcode.easy;

public class E189_Rotate_Array {

	public void rotate(int[] nums, int k) {
		if (nums == null || nums.length == 0)
			return;
		k = k % nums.length;

		int[] arr = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			arr[i] = nums[i];
		}
		int j = 0;
		for (int i = nums.length - k; i < nums.length; i++, j++) {
			nums[j] = arr[i];
		}
		for (int i = 0; i < nums.length - k; i++) {
			nums[j++] = arr[i];
		}
	}
}
