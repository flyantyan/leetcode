package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class M46_Permutations {
	/////////////========start
	 public List<List<Integer>> permute_1(int[] nums) {
	        List<List<Integer>> result = new ArrayList<>() ;
	        if(nums == null)
	            return result ;
	        permute(nums , 0 , result) ;
	        return result ;
	    }
	    
	    private void permute(int[] nums , int k , List<List<Integer>> result){
	        if(k == nums.length){
	            List<Integer> r = new ArrayList<>() ;
	            for(int i = 0 ; i < nums.length; i++)
	                r.add(nums[i]);
	            result.add(r) ;
	            return ;
	        }
	        
	        for(int i = k ; i < nums.length ; i++){
	            swap(nums , i , k);
	            permute(nums , k+1 , result);
	            swap(nums , i , k);
	        }
	    }
	    
	    private void swap(int arr[] , int i , int j){
	        int temp = arr[i] ;
	        arr[i] = arr[j] ;
	        arr[j] = temp ;
	    }
	////////////=========end
	
	
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		helper(nums, new ArrayList<Integer>(), res);
		return res;
	}

	private void helper(int[] nums, List<Integer> item, List<List<Integer>> res) {
		// base case
		if (item.size() == nums.length) {
			res.add(new ArrayList<Integer>(item));
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			if (isValidFill(item, nums[i])) {
				helper(nums, item, res);
				item.remove(item.size() - 1);
			}
		}
	}

	private boolean isValidFill(List<Integer> item, int element) {
		if (!item.contains(element)) {
			item.add(element);
			return true;
		}
		return false;
	}
}
