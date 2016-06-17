package leetcode.medium;

public class M161_One_Edit_Distance {

	public boolean isOneEditDistance(String s, String t) {
		if (s == null || t == null)
			return false;
		if (s.length() > t.length()) {
			String temp = s;
			s = t;
			t = temp;
		}

		if (t.length() - s.length() >= 2)
			return false;
		if (t.length() == s.length()) {
			int count = 0;
			for (int i = 0; i < s.length(); i++) {
				if (t.charAt(i) != s.charAt(i))
					count++;
			}
			return count == 1;
		} else {
			for (int i = 0; i < s.length(); i++) {
				if (t.charAt(i) != s.charAt(i)) {
					return s.substring(i).equals(t.substring(i + 1));
				}
			}
			return true;
		}
	}
}
