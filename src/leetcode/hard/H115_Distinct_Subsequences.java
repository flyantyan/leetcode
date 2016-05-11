package leetcode.hard;

public class H115_Distinct_Subsequences {

	public int numDistinct(String s, String t) {
		int result[][] = new int[s.length() + 1][t.length() + 1];

		for (int i = 0; i < s.length(); i++) {
			result[i][0] = 1;
		}

		for (int i = 0; i < s.length(); i++) {
			for (int j = 0; j < t.length(); j++) {
				result[i + 1][j + 1] = (s.charAt(i) == t.charAt(j) ? result[i][j] : 0) + result[i][j + 1];
			}
		}

		return result[s.length()][t.length()];
	}
}
