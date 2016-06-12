package leetcode.medium;

import java.util.Set;

public class M139_Word_Break {

	public boolean wordBreak(String s, Set<String> wordDict) {
		if (s == null)
			return false;
		boolean dp[] = new boolean[s.length() + 1];
		dp[0] = true;

		for (int i = 1; i <= s.length(); i++) {
			for (int j = 1; j <= i && !dp[i]; j++)
				dp[i] = wordDict.contains(s.substring(j - 1, i)) && dp[j - 1];
		}

		return dp[s.length()];
	}
}
