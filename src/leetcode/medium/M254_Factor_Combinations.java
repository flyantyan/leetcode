package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class M254_Factor_Combinations {

	public List<List<Integer>> getFactors(int n) {
		List<List<Integer>> result = new ArrayList<>();
		if (n <= 1)
			return result;
		dfs(result, new ArrayList<Integer>(), n, 2);
		result.remove(result.size() - 1);
		return result;
	}

	private void dfs(List<List<Integer>> result, List<Integer> temp, int n, int factor) {
		if (n <= 1) {
			result.add(new ArrayList<Integer>(temp));
			return;
		}

		for (int i = factor; i <= n; i++) {
			if (n % i == 0) {
				temp.add(i);
				dfs(result, temp, n / i, i);
				temp.remove(temp.size() - 1);
			}
		}
	}
}
