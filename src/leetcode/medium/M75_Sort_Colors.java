package leetcode.medium;

public class M75_Sort_Colors {

	public void sortColors(int[] nums) {
		int end0 = 0;
		int start1 = 0;
		int end2 = nums.length - 1;

		for (start1 = 0; start1 <= end2; start1++) {
			switch (nums[start1]) {
			case 0:
				swap(nums, end0++, start1);
				break;

			case 2:
				swap(nums, start1--, end2--);
				break;
			}
		}
	}

	private void swap(int nums[], int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	public void sortColors2(int[] nums) {
		int n0 = -1;
		int n1 = -1;
		int n2 = -1;

		for (int i = 0; i < nums.length; i++) {
			switch (nums[i]) {
			case 0:
				nums[++n2] = 2;
				nums[++n1] = 1;
				nums[++n0] = 0;
				break;
			case 1:
				nums[++n2] = 2;
				nums[++n1] = 1;
				break;
			case 2:
				nums[++n2] = 2;
				break;
			}
		}
	}

	public void sortColors1(int[] nums) {
		int bucket[] = new int[3];

		for (int n : nums) {
			bucket[n]++;
		}

		for (int i = 0; i < bucket[0]; i++) {
			nums[i] = 0;
		}
		for (int i = 0; i < bucket[1]; i++) {
			nums[i + bucket[0]] = 1;
		}

		for (int i = 0; i < bucket[2]; i++) {
			nums[i + bucket[0] + bucket[1]] = 2;
		}
	}
}
