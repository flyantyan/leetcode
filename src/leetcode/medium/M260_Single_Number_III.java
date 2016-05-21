package leetcode.medium;

public class M260_Single_Number_III {

	public int[] singleNumber(int[] nums) {
		if (nums == null) {
			return null;
		}
		int result[] = new int[2];

		// Phase1 : find the XOR of the two number that we need to find
		int diff = 0;
		for (int i : nums) {
			diff ^= i;
		}
		// Get the last set bit
		diff &= (-diff + 1);
		// diff &= -diff;

		for (int num : nums) {
			if ((num & diff) == 0) {
				result[0] ^= num;
			} else {
				result[1] ^= num;
			}
		} 

		return result;
	}
}
