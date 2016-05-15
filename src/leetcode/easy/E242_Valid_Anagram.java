package leetcode.easy;

public class E242_Valid_Anagram {

	public boolean isAnagram(String s, String t) {
		if (s == null || t == null || s.length() != t.length())
			return false;

		int[] nums = new int[26];
		char[] arrS = s.toCharArray();
		char[] arrT = t.toCharArray();
		for (int i = 0; i < s.length(); i++)
			nums[arrS[i] - 'a']++;

		for (int i = 0; i < t.length(); i++) {
			if (nums[arrT[i] - 'a'] == 0)
				return false;

			nums[arrT[i] - 'a']--;
		}

		return true;
	}
}
