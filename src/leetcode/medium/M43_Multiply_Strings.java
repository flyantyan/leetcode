package leetcode.medium;

public class M43_Multiply_Strings {
	//https://leetcode.com/discuss/71593/easiest-java-solution-with-graph-explanation
	public String multiply(String num1, String num2) {
		int[] result = new int[num1.length() + num2.length()];

		for (int i = num1.length() - 1; i >= 0; i--) {
			for (int j = num2.length() - 1; j >= 0; j--) {
				int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');

				int sum = mul + result[i + j + 1];

				result[i + j + 1] = sum % 10;
				result[j + i] += sum / 10;
			}
		}

		StringBuilder sb = new StringBuilder();

		for (int p : result)
			if (!(sb.length() == 0 && p == 0))
				sb.append(p);

		return sb.length() == 0 ? "0" : sb.toString();
	}
}
