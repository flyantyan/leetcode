package leetcode.easy;

public class E38_Count_and_Say {
	public String countAndSay(int n) {
		String str = "1";
		for (int i = 2; i <= n; i++) {
			str = countAndSay(str);
		}
		return str;
	}

	private String countAndSay(String str) {
		StringBuilder result = new StringBuilder("");
		int count = 1;
		char currentChar = str.charAt(0);

		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) == currentChar) {
				count++;
			} else {
				result.append(count + "" + currentChar);
				count = 1;
				currentChar = str.charAt(i);
			}
		}

		if (count > 0)
			result.append(count + "" + currentChar);

		return result.toString();

	}
}
