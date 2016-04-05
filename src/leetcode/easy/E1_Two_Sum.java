package leetcode.easy;

import java.util.Arrays;

/**
 * 
 * @author yanfei
 *
 */
public class E1_Two_Sum {

	public static void main(String[] args) {
		int[] nums = new int[]{7,7,7,2,3};
		int target = 9;
		int [] i = twoSum(nums, target);
		System.out.println(Arrays.toString(i));
	}

	public static int[] twoSum(int[] nums, int target) {
		if(nums.length < 2)
			return null ;
		
		if(nums.length == 2){
			if(nums[0] + nums[1] == target)
				return new int[]{0,1};
			else
				return null ;
		}
		
		
		for(int i = 0 ; i < nums.length ; i ++){
			for(int j = i + 1 ; j <nums.length ; j ++){
				if(nums[i] + nums[j] == target)
					return new int[]{i,j};
			}
		}
		return null ;
	}

}
