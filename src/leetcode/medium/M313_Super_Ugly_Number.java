package leetcode.medium;

public class M313_Super_Ugly_Number {

	public int nthSuperUglyNumber(int n, int[] primes) {
		if (n < 1) {
			return 0;
		}
		int len = primes.length;
		int[] index = new int[len];
		int[] dp = new int[n];
		dp[0] = 1;

		for (int i = 1; i < n; i++) {
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < len; j++) { // try update with all primes
				min = Math.min(dp[index[j]] * primes[j], min);
			}
			dp[i] = min; // find dp[i]
			for (int j = 0; j < len; j++) { // if prices[j] is used, increase
											// the index
				if (dp[i] % primes[j] == 0) {
					index[j]++;
				}
			}
		}
		return dp[n - 1];
	}
}
