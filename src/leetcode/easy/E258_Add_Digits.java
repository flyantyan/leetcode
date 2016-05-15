package leetcode.easy;

public class E258_Add_Digits {

	public int addDigits(int n) {
		return 1 + (n - 1) % 9;
	}
}
