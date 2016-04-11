package leetcode.easy;

public class E14_Longest_Common_Prefix {

	public String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0)
			return "";

		if (strs.length == 1)
			return strs[0];

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < strs[0].length(); i++) {
			for (int j = 1; j < strs.length; j++) {
				if (i >= strs[j].length() || strs[0].charAt(i) != strs[j].charAt(i))
					return sb.toString();
			}
			sb.append(strs[0].charAt(i));
		}
		return sb.toString();
	}
}
