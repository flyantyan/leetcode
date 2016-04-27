package leetcode.easy;

public class E70_Climbing_Stairs {

	public int climbStairs(int n) {
		if (n <= 2)
			return n;

		int t1 = 1;
		int t2 = 2;
		int t3 = 0;

		for (int i = 3; i <= n; i++) {
			t3 = t1 + t2;
			t1 = t2;
			t2 = t3;
		}

		return t3;
	}

	public int climbStairs1(int n) {
		if (n <= 2)
			return n;
		int result[] = new int[n + 1];
		result[0] = 0;
		result[1] = 1;
		result[2] = 2;

		for (int i = 3; i <= n; i++) {
			result[i] = result[i - 1] + result[i - 2];
		}
		return result[n];
	}

	// Time Limit Exceeded
	// public int climbStairs(int n) {
	// if(n <= 2)
	// return n ;

	// return climbStairs(n-1) + climbStairs(n-2);
	// }
}
