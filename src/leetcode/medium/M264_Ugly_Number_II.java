package leetcode.medium;

public class M264_Ugly_Number_II {

	public int nthUglyNumber(int n) {
		if (n <= 1)
			return n;
		int uglys[] = new int[n];
		uglys[0] = 1;
		int index2 = 0;
		int index3 = 0;
		int index5 = 0;
		int num2 = 2, num3 = 3, num5 = 5;
		for (int i = 1; i < n; i++) {
			int min = Math.min(Math.min(num2, num3), num5);
			uglys[i] = min;
			if (min == num2) {
				num2 = 2 * uglys[++index2];
			}
			if (min == num3) {
				num3 = 3 * uglys[++index3];
			}
			if (min == num5) {
				num5 = 5 * uglys[++index5];
			}
		}

		return uglys[n - 1];

	}
}
