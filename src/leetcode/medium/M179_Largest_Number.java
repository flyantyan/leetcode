package leetcode.medium;


//Sort :
//A+B > B+A  ====> A > B
public class M179_Largest_Number {

	public String largestNumber(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0 + "";
		String[] strNums = new String[nums.length];
		for (int i = 0; i < nums.length; i++) {
			strNums[i] = nums[i] + "";
		}

		sort(strNums);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < strNums.length; i++) {
			sb.append(strNums[i]);
		}
		String result = sb.toString();
		// [0.0]==>00
		return (result.isEmpty() || result.startsWith("0")) ? "0" : result;
	}

	// sort by zidianxu
	private void sort(String[] nums) {
		if (nums == null || nums.length == 0)
			return;

		for (int i = 1; i < nums.length; i++) {
			String num = nums[i];
			int j = i;
			for (j = i; j > 0; j--) {
				String num1 = nums[j - 1];
				if (compare(num, num1)) {
					nums[j] = nums[j - 1];
				} else {
					break;
				}
			}
			nums[j] = num;
		}
	}

	private boolean compare(String num1, String num2) {
		int i = 0;
		String num12 = num1 + num2;
		String num21 = num2 + num1;
		while (i < num12.length()) {
			if (num12.charAt(i) > num21.charAt(i))
				return true;
			else if (num12.charAt(i) < num21.charAt(i)) {
				return false;
			}

			i++;
		}

		return false;
	}

	public static void main(String[] args) {
		new M179_Largest_Number().largestNumber(new int[] { 2, 3, 30, 31 });
	}
}
