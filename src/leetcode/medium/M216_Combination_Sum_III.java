package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class M216_Combination_Sum_III {

	public List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> result = new ArrayList<>();
		combinationSum(result, new ArrayList<>(), 1, n, k);
		return result;
	}

	private void combinationSum(List<List<Integer>> result, List<Integer> temp, int start, int n, int k) {
		if (temp.size() == k && n == 0) {
			result.add(new ArrayList<>(temp));
			return;
		}

		for (int i = start; i <= 9; i++) {
			temp.add(i);
			combinationSum(result, temp, i + 1, n - i, k);
			temp.remove(temp.size() - 1);
		}
	}
}
