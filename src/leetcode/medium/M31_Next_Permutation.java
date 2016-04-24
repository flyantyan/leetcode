package leetcode.medium;

public class M31_Next_Permutation {
	public void nextPermutation(int[] nums) {
		if (nums.length < 2)
			return;
		if (nums.length == 2) {
			swap(nums, 0, 1);
			return;
		}
		int i = nums.length - 2;
		while (i >= 0) {
			if (nums[i] < nums[i + 1])
				break;
			i--;
		}

		if (i == -1) {
			reverse(nums, 0);
			return;
		}
		int j = nums.length - 1;

		while (j > i) {
			if (nums[j] > nums[i])
				break;
			j--;
		}

		swap(nums, i, j);
		reverse(nums, i + 1);
	}

	private void reverse(int nums[], int j) {
		for (int i = j; i < nums.length; i++) {
			for (int k = i + 1; k < nums.length; k++) {
				if (nums[i] > nums[k])
					swap(nums, i, k);
			}
		}
	}

	private void swap(int nums[], int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	public static void main(String[] args) {
		new M31_Next_Permutation().nextPermutation(new int[] { 1, 3, 2 });
	}
}
