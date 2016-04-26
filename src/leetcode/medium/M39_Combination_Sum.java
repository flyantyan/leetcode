package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class M39_Combination_Sum {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		Arrays.sort(candidates);
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		dfs(result, new LinkedList<Integer>(), candidates, target, candidates.length - 1);
		return result;
	}

	private void dfs(List<List<Integer>> result, LinkedList<Integer> temp, int[] candidates, int target, int end) {
		if (target == 0) {
			result.add(new LinkedList<>(temp));
			return;
		}

		if (target < 0)
			return;

		for (int i = end; i >= 0; i--) {
			if (candidates[i] <= target) {
				temp.addFirst(candidates[i]);
				dfs(result, temp, candidates, target - candidates[i], i);
				temp.removeFirst();
			}
		}
	}
}
