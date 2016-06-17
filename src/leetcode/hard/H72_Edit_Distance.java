package leetcode.hard;

public class H72_Edit_Distance {

	public int minDistance(String word1, String word2) {
		if (word1 == null)
			return (word2 == null) ? 0 : word2.length();
		if (word2 == null)
			return word1.length();

		int[][] dp = new int[word1.length() + 1][word2.length() + 1];
		for (int i = 0; i <= word1.length(); i++)
			dp[i][0] = i;
		for (int i = 0; i <= word2.length(); i++)
			dp[0][i] = i;
		for (int i = 1; i <= word1.length(); i++) {
			for (int j = 1; j <= word2.length(); j++) {
				char c1 = word1.charAt(i - 1);
				char c2 = word2.charAt(j - 1);
				if (c1 == c2)
					dp[i][j] = dp[i - 1][j - 1];
				else {
					dp[i][j] = Math.min(dp[i - 1][j - 1] + 1, Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1));
				}
			}
		}

		return dp[word1.length()][word2.length()];
	}
}
