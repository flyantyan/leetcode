package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class M78_Subsets {
	public List<List<Integer>> subsets(int[] S) {
		List<List<Integer>> res = new ArrayList<>();
		res.add(new ArrayList<Integer>());

		Arrays.sort(S);
		for (int i : S) {
			List<List<Integer>> tmp = new ArrayList<>();
			for (List<Integer> sub : res) {
				List<Integer> a = new ArrayList<>(sub);
				a.add(i);
				tmp.add(a);
			}
			res.addAll(tmp);
		}
		return res;
	}
	
	
	public static void main(String[] args) {
		new M78_Subsets().subsets(new int[]{1,2,3,4,5,6,7,8});
	}
}
