package leetcode.easy;

public class E66_Plus_One {

	public int[] plusOne1(int[] digits) {

		if (digits == null)
			return digits;

		for (int i = digits.length - 1; i >= 0; i--) {
			if (digits[i] < 9) {
				digits[i]++;
				return digits;
			}
			digits[i] = 0;
		}

		int[] result = new int[digits.length + 1];
		result[0] = 1;

		return result;

	}

	public int[] plusOne(int[] digits) {
		int add = 1;
		for (int i = digits.length - 1; i >= 0; i--) {
			int sum = digits[i] + add;
			digits[i] = sum % 10;
			add = sum / 10;
		}

		if (add == 0)
			return digits;
		else {
			int result[] = new int[digits.length + 1];
			result[0] = 1;
			return result;
		}
	}
}
