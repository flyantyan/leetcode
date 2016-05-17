package leetcode.hard;

public class H132_Palindrome_Partitioning_II {

	public int minCut(String s) {
		char[] strs = s.toCharArray();
		int mins[] = new int[s.length()];
		boolean isPalindrome[][] = new boolean[s.length()][s.length()];

		for (int i = 0; i < s.length(); i++) {
			int min = i;
			for (int j = 0; j <= i; j++) {
				if (strs[i] == strs[j] && (j + 1 > i - 1 || isPalindrome[j + 1][i - 1])) {
					isPalindrome[j][i] = true;
					min = j == 0 ? 0 : Math.min(min, mins[j - 1] + 1);
				}
			}
			mins[i] = min;
		}

		return mins[s.length() - 1];
	}
}
