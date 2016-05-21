package leetcode.medium;

public class M306_Additive_Number {

	public boolean isAdditiveNumber_1(String num) {
		if (num == null || num.length() < 3)
			return false;
		int n = num.length();
		for (int i = 1; i < n; i++) {
			if (i > 1 && num.charAt(0) == '0')
				break;
			for (int j = i + 1; j < n; j++) {
				int first = 0, second = i, third = j;
				if (num.charAt(second) == '0' && third > second + 1)
					break;
				while (third < n) {
					Long result = (Long.parseLong(num.substring(first, second))
							+ Long.parseLong(num.substring(second, third)));
					if (num.substring(third).startsWith(result.toString())) {
						first = second;
						second = third;
						third += result.toString().length();
					} else {
						break;
					}
				}
				if (third == n)
					return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		new M306_Additive_Number().isAdditiveNumber_1("111");
	}
}
