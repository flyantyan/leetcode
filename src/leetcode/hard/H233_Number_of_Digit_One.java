package leetcode.hard;

public class H233_Number_of_Digit_One {

	// intuitive: 每10个数, 有一个个位是1, 每100个数, 有10个十位是1, 每1000个数, 有100个百位是1. 做一个循环,
	// 每次计算单个位上1得总个数(个位,十位, 百位).
	// (a + 8) / 10 * m + (a % 10 == 1) * (b + 1);
	public int countDigitOne(int n) {
		int ones = 0;
		for (long m = 1; m <= n; m *= 10) {
			long a = n / m, b = n % m;
			ones += (a + 8) / 10 * m;
			if (a % 10 == 1)
				ones += b + 1;
		}
		return ones;
	}
}
