package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

import leetcode.TreeNode;

public class M113_Path_Sum_II {
	public void pathSumInner(TreeNode root, int sum, List<Integer> path, List<List<Integer>> result) {
		path.add(root.val);
		if (root.left == null && root.right == null)
			if (sum == root.val)
				result.add(new ArrayList<Integer>(path));
		if (root.left != null)
			pathSumInner(root.left, sum - root.val, path, result);
		if (root.right != null)
			pathSumInner(root.right, sum - root.val, path, result);
		path.remove(path.size() - 1);
	}

	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> resultList = new ArrayList<List<Integer>>();
		if (root == null)
			return resultList;
		List<Integer> currentPath = new ArrayList<Integer>();
		pathSumInner(root, sum, currentPath, resultList);
		return resultList;
	}
}
