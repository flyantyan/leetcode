package leetcode.medium;

public class M307_Range_Sum_Query_Mutable {

	private int[] num;
	private int[] BTsum;
	private int len;

	public M307_Range_Sum_Query_Mutable(int[] nums) {
        len = nums.length;
        BTsum = new int[len+1];
        num = new int[len];
        for(int i = 0; i<len; i++){
            update(i, nums[i]);
        }
    }

	void update(int i, int val) {
		int diff = val - num[i];
		num[i++] = val;
		while (i <= len) {
			BTsum[i] += diff;
			i += (-i & i);
		}
	}

	private int getsum(int i) {
		int sum = 0;
		i++;
		while (i > 0) {
			sum += BTsum[i];
			i -= (-i & i);
		}
		return sum;
	}

	public int sumRange(int i, int j) {
		return getsum(j) - getsum(i - 1);
	}
}
