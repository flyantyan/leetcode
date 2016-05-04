package leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class M77_Combinations {
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (k > n)
			return result;
		dfs(result, new LinkedList<Integer>(), k, 1, n);
		return result;
	}

	private void dfs(List<List<Integer>> result, LinkedList<Integer> temp, int num, int start, int end) {
		if (num == 0) {
			result.add(new LinkedList<>(temp));
			return;
		}

		for (int i = start; i <= end; i++) {
			temp.add(i);
			dfs(result, temp, num - 1, i + 1, end);
			temp.removeLast();
		}
	}
}
