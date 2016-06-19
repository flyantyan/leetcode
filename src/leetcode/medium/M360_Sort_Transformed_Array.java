package leetcode.medium;

public class M360_Sort_Transformed_Array {

	public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
		if (nums == null)
			return null;
		int[] result = new int[nums.length];

		int left = 0;
		int right = nums.length - 1;
		int index = a > 0 ? nums.length - 1 : 0;
		while (left <= right) {
			int val1 = a * nums[left] * nums[left] + b * nums[left] + c;
			int val2 = a * nums[right] * nums[right] + b * nums[right] + c;
			if (a > 0) {
				if (val1 > val2) {
					result[index--] = val1;
					left++;
				} else {
					result[index--] = val2;
					right--;
				}
			} else {
				if (val1 < val2) {
					result[index++] = val1;
					left++;
				} else {
					result[index++] = val2;
					right--;
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		new M360_Sort_Transformed_Array().sortTransformedArray(new int[] { -4, -2, 2, 4 }, 1, 3, 5);
	}
}
