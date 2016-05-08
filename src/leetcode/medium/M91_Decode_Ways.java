package leetcode.medium;

public class M91_Decode_Ways {

	/**
	 * 注意：0的考虑    
	 * 		Start with 0 is error
	 * 		10,20 are specific
	 * 		
	 * f(n) = f(n-1) +f(n-2)
	 * Because n2 are so many case,so we create an unexist num before n1 ,don't change the result, so initial n1 and n2 for 1
	 * @param s
	 * @return
	 */
	public int numDecodings(String s) {
		int n1 = 1, n2 = 1, temp = 0;
		if (s.length() == 0 || s.charAt(0) == '0')
			return 0;
		for (int i = 1; i < s.length(); i++) {
			temp = 0;
			if (s.charAt(i) != '0')
				temp = n2;
			int num = Integer.parseInt(s.substring(i - 1, i+1));
			if (num >= 10 && num <= 26)
				temp += n1;
			n1 = n2;
			n2 = temp;
		}
		return n2;
	}

	int helper(String s, int start, int total) {
		if (start >= s.length() - 1)
			return total;
		int num = (s.charAt(start) - '0') * 10 + s.charAt(start + 1) - '0';

		return helper(s, start + 1, 1) + (num <= 26 ? helper(s, start + 2, 1) : 0);

	}

	public static void main(String[] args) {
		int n = new M91_Decode_Ways().numDecodings("1");
		System.out.println(n+"===");
//		syso
	}
}
