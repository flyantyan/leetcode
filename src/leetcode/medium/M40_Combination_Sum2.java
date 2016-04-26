package leetcode.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class M40_Combination_Sum2 {
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates);
		Set<List<Integer>> result = new HashSet<List<Integer>>();
		dfs(result, new LinkedList<Integer>(), candidates, target, candidates.length - 1);
		return new LinkedList<>(result);
	}

	private void dfs(Set<List<Integer>> result, LinkedList<Integer> temp, int[] candidates, int target, int end) {
		if (target == 0) {
			result.add(new LinkedList<>(temp));
			return;
		}

		if (target < 0)
			return;

		for (int i = end; i >= 0; i--) {
			if (candidates[i] <= target) {
				temp.addFirst(candidates[i]);
				dfs(result, temp, candidates, target - candidates[i], i - 1);
				temp.removeFirst();
			}
		}
	}
}
