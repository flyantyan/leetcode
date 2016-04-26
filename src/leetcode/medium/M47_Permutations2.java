package leetcode.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class M47_Permutations2 {
	public List<List<Integer>> permuteUnique(int[] nums) {
		Set<List<Integer>> result = new HashSet<List<Integer>>();

		List<Integer> l0 = new ArrayList<Integer>();
		l0.add(nums[0]);
		result.add(l0);

		for (int i = 1; i < nums.length; i++) {
			Set<List<Integer>> new_result = new HashSet<List<Integer>>();
			for (int j = 0; j <= i; j++) {
				for (List<Integer> r : result) {
					List<Integer> temp = new ArrayList<Integer>(r);
					temp.add(j, nums[i]);
					new_result.add(temp);
				}
			}
			result = new_result;
		}
		return new LinkedList(result);
	}
}
