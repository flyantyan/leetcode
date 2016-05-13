package leetcode.easy;

public class E125_Valid_Palindrome {

	public boolean isPalindrome(String s) {
		if (s == null)
			return false;

		int start = 0;
		int end = s.length() - 1;

		while (start < end) {
			char cs = s.charAt(start);
			char st = s.charAt(end);
			if (!Character.isLetterOrDigit(cs)) {
				start++;
			} else if (!Character.isLetterOrDigit(st)) {
				end--;
			} else {
				if (Character.toLowerCase(cs) != Character.toLowerCase(st))
					return false;
				start++;
				end--;

			}

		}

		return true;
	}
}
