package leetcode.medium;

public class M5_Longest_Palindromic_Substring {

	   public String longestPalindrome(String s) {

			StringBuilder sb = new StringBuilder("#");

			for (int i = 0; i < s.length(); i++) {
				sb.append(s.charAt(i));
				sb.append("#");
			}

			int P[] = new int[sb.length()];
			int C = 0, R = 0;
			for (int i = 0; i < sb.length(); i++) {
				int i_mirror = C - (i - C);
				P[i] = (i_mirror >= 0) ? Math.min(R - i, P[i_mirror]) : 0;

				// Extend
				int left = i - P[i]-1;
				int right = i + P[i]+1;
				while (left >= 0 && right < sb.length() && sb.charAt(left) == sb.charAt(right)) {
					P[i]++;
					left--;
					right++;
				}

				if (i + P[i] > R) {
					R = i + P[i];
					C = i;
				}
			}

			int currentIndex = 0;
			int max = 0;

			for (int i = 0; i < P.length; i++) {
				if (P[i] > max) {
					max = P[i];
					currentIndex = i;
				}
			}
			return s.substring((currentIndex  - max) / 2, (currentIndex + max) / 2);
		}

	public static void main(String[] args) {
		String a = new M5_Longest_Palindromic_Substring().longestPalindrome("aaaaaaa");
		System.out.println(a);
	}

}
