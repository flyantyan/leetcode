package leetcode.easy;

public class E172_Factorial_Trailing_Zeroes {

	public int trailingZeroes(int n) {
		int cnt = 0;
		while (n > 0) {
			cnt += n / 5;
			n /= 5;
		}
		return cnt;
	}
}
