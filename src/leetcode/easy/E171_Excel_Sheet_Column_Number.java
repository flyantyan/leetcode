package leetcode.easy;

public class E171_Excel_Sheet_Column_Number {

	public int titleToNumber(String s) {
		if (s == null)
			return 0;

		char arrS[] = s.toCharArray();
		int result = 0;
		for (int i = 0; i < s.length(); i++) {
			result = (arrS[i] - 'A') + 1 + result * 26;
		}

		return result;
	}
}
