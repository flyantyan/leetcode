package leetcode.easy;

public class E191_Number_of_1_Bits {

	public int hammingWeight(int n) {
		int ones = 0;
		while (n != 0) {
			ones = ones + (n & 1);
			n = n >>> 1;
		}
		return ones;
	}
}
