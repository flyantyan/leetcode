package leetcode.easy;

public class E168_Excel_Sheet_Column_Title {

	public String convertToTitle(int n) {
		StringBuilder result = new StringBuilder();
		while (n > 0) {
			n--;
			result.append((char) ('A' + n % 26) + "");
			n /= 26;
		}

		return result.reverse().toString();
	}
}
