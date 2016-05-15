package leetcode.easy;

public class E326_Power_of_Three {

	public boolean isPowerOfThree(int num) {
		while (num >= 3) {
			if (num % 3 != 0)
				return false;
			num /= 3;
		}
		return num == 1;
	}
}
