package leetcode.medium;

public class M279_Perfect_Squares {

	public int numSquares(int n) {
		if (n < 1) {
			return 0;
		}
		int[] min = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			int tmp = Integer.MAX_VALUE;
			for (int j = 1; j * j <= i; j++) {
				tmp = Math.min(tmp, min[i - j * j] + 1);
			}
			min[i] = tmp;
		}

		return min[n];
	}
}
