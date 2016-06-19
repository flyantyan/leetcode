package leetcode.medium;

public class M276_Paint_Fence {

	public int numWays(int n, int k) {
		if (n == 0)
			return 0;
		if (n == 1)
			return k;
		int sameCount = k;
		int diffCount = k * (k - 1);

		for (int i = 3; i <= n; i++) {
			int temp = diffCount;
			diffCount = diffCount * (k - 1) + sameCount * (k - 1);
			sameCount = temp;
		}
		return sameCount + diffCount;
	}
}
