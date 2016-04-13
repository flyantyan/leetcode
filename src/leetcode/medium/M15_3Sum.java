package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * TestCase [0.0.0.0]
 * 
 * @author yanfei
 *
 */
public class M15_3Sum {

	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		if (nums == null || nums.length < 3)
			return result;

		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 2; i++) {
			if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
				int end = nums.length - 1;
				int start = i + 1;
				int target = nums[i];

				while (start < end) {
					if (nums[start] + nums[end] == -1 * target) {
						result.add(Arrays.asList(target, nums[start], nums[end]));

						while (start < end && nums[start] == nums[start + 1])
							start++;
						while (start < end && nums[end] == nums[end - 1])
							end--;
						start++;
						end--;

					} else if (nums[start] + nums[end] < -1 * target) {
						while (start < end && nums[start] == nums[start + 1])
							start++;
						start++;
					} else {
						while (start < end && nums[end] == nums[end - 1])
							end--;
						end--;
					}
				}
			}

		}
		return result;
	}

	// public List<List<Integer>> threeSum(int [] nums){
	// List<List<Integer>> result = new ArrayList<>();
	// if(nums == null || nums.length < 3)
	// return result ;
	//
	//
	//
	//

	// Arrays.sort(nums);
	// for(int i = 0 ; i < nums.length -2 ; i ++){
	// if (i == 0 || (i > 0 && nums[i] != nums[i-1])) {
	// result.addAll(twoSum(nums, i+1, nums[i]));
	// }
	// }
	//
	// return result ;
	// }

	// public List<List<Integer>> twoSum(int[]nums , int start , int target){
	// List<List<Integer>> result = new ArrayList<>();
	// if(nums.length - start < 2 ){
	// return result ;
	// }
	//
	// int end = nums.length-1 ;
	// while(start < end){
	// if(nums[start] + nums[end] == -1*target){
	// result.add(Arrays.asList(target , nums[start] , nums[end]));
	//
	// while(start < end && nums[start] == nums[start+1])
	// start++;
	// while(start < end && nums[end] == nums[end-1])
	// end--;
	// start++;
	// end--;
	//
	// }else if(nums[start] + nums[end] < -1*target){
	// while(start < end && nums[start] == nums[start+1])
	// start++;
	// }else{
	// while(start < end && nums[end] == nums[end-1])
	// end--;
	// }
	// }
	//
	//
	// return result ;
	// }

	/**************** 1 ************************/
	// public List<List<Integer>> threeSum(int[] nums) {
	// if (nums == null || nums.length < 3) {
	// return null;
	// }
	//
	// List<List<Integer>> result = new ArrayList<List<Integer>>();
	//
	// List<Integer> tmp = new ArrayList<Integer>();
	//
	// for (int i = 0; i < nums.length; i++) {
	// for (int j = i + 1; j < nums.length; j++) {
	// for (int m = j + 1; m < nums.length; m++) {
	// if (nums[i] + nums[j] + nums[m] == 0) {
	// tmp = new ArrayList<Integer>();
	// tmp.add(nums[i]);
	// tmp.add(nums[j]);
	// tmp.add(nums[m]);
	// result.add(tmp);
	// }
	// }
	// }
	// }
	// return result;
	// }
}
