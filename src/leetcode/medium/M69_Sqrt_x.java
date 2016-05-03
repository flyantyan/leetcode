package leetcode.medium;

public class M69_Sqrt_x {
	public int mySqrt(int x) {
		if (x <= 1)
			return x;
		int left = 1;
		int right = x;

		while (left < right) {
			int mid = left + (right - left) / 2;
			if (mid > x / mid) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		return left - 1;
	}
}
