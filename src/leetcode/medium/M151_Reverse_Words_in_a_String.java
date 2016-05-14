package leetcode.medium;

public class M151_Reverse_Words_in_a_String {

	// "a" " 1" " a b "
	public String reverseWords(String s) {
		if (s == null)
			return s;

		String strs[] = s.trim().split(" ");
		StringBuilder result = new StringBuilder("");
		if (strs.length == 1)
			return s.trim();
		for (int i = strs.length - 1; i >= 0; i--) {
			if (strs[i].trim().length() > 0)
				result.append(strs[i] + " ");
		}

		return result.toString().trim();
	}
}
