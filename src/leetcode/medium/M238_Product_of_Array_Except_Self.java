package leetcode.medium;

public class M238_Product_of_Array_Except_Self {

	public int[] productExceptSelf(int[] nums) {
		if (nums == null || nums.length <= 1) {
			return nums;
		}
		int[] result = new int[nums.length];
		result[0] = 1;
		for (int i = 1; i < nums.length; i++) {
			result[i] = result[i - 1] * nums[i - 1];
		}

		int right = 1;
		for (int i = nums.length - 1; i >= 0; i--) {
			result[i] *= right;
			right *= nums[i];
		}

		return result;

	}

	// Time limit exceeded
	// public int[] productExceptSelf(int[] nums) {
	// if(nums == null || nums.length <=1)
	// return nums ;
	// int[]result = new int[nums.length];

	// for(int i = 0 ; i < nums.length ; i++){
	// if(nums[i] == 0)
	// continue ;
	// result[i] = 1 ;
	// for(int j = 0 ; j < nums.length;j++ ){
	// if(j!=i)
	// result[i] *= nums[j] ;
	// }
	// }
	// return result ;
	// }
}
