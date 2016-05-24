package leetcode.easy;

public class E190_Reverse_Bits {

	public int reverseBits(int n) {
		int answer = 0; // initializing answer
		for (int i = 0; i < 32; i++) { // 32 bit integers
			answer <<= 1; // shifts answer over 1 to open a space
			answer |= ((n >> i) & 1); // inserts bits from n
		}
		return answer;
	}
}
