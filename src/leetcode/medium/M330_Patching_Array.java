package leetcode.medium;

public class M330_Patching_Array {

	public int minPatches(int[] nums, int n) {
		int cnt = 0, i = 0;
		for (long known_sum = 1; known_sum <= n;) {
			if (i < nums.length && known_sum >= nums[i]) {
				known_sum += nums[i++];
			} else {
				known_sum <<= 1;
				cnt++;
			}
		}
		return cnt;
	}
}
