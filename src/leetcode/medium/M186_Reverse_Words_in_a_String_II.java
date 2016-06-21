package leetcode.medium;

public class M186_Reverse_Words_in_a_String_II {

	public void reverseWords(char[] s) {
		reverseWords(s, 0, s.length - 1);
		for (int i = 0, j = 0; i <= s.length; i++) {
			if (i == s.length || s[i] == ' ') {
				reverseWords(s, j, i - 1);
				j = i + 1;
			}
		}
	}

	private void reverseWords(char[] s, int begin, int end) {
		while (begin < end) {
			char c = s[begin];
			s[begin] = s[end];
			s[end] = c;
			begin++;
			end--;
		}
	}
}
