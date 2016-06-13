package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class M17_Letter_Combinations_of_a_Phone_Number {

	private String[] mapping = new String[] { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

	public List<String> letterCombinations(String digits) {
		List<String> result = new ArrayList<String>();
		if (digits == null || digits.length() == 0 || digits.contains("1") || digits.contains("0"))
			return result;
		dfs(result, new StringBuilder(), 0, digits);
		return result;
	}

	private void dfs(List<String> result, StringBuilder sb, int index, String digits) {
		if (index == digits.length()) {
			result.add(sb.toString());
			return;
		}
		String letter = mapping[digits.charAt(index) - '0'];
		for (int i = 0; i < letter.length(); i++) {
			sb.append(letter.charAt(i));
			dfs(result, sb, index + 1, digits);
			sb.deleteCharAt(sb.length() - 1);
		}
	}
}
