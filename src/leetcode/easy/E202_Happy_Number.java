package leetcode.easy;

public class E202_Happy_Number {

	public boolean isHappy(int n) {
		int sum = 0;
		while (true) {
			while (n > 0) {
				sum += Math.pow(n % 10, 2);
				n /= 10;
			}
			if (sum == 1 || sum == 7)
				return true;
			else if (sum < 10)
				return false;

			n = sum;
			sum = 0;
		}
	}
}
