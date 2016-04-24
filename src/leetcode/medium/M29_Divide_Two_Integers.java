package leetcode.medium;

public class M29_Divide_Two_Integers {
	public int divide(int dividend, int divisor) {
		if (dividend == 0)
			return 0;
		boolean flag = (dividend < 0) ^ (divisor < 0);

		long m = Math.abs((long) dividend), n = Math.abs((long) divisor);
		long result = 0;
		while (m >= n) {
			int shift = 0;
			while (m > (n << (shift + 1))) {
				shift++;
			}

			m -= n << shift;
			result += 1 << shift;
		}

		result = (flag) ? ~(result - 1) : result;
		result = Math.max(result, Integer.MIN_VALUE);
		result = Math.min(result, Integer.MAX_VALUE);
		return (int) result;
	}
}
