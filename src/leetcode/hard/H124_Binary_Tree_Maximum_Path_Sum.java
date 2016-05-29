package leetcode.hard;

import leetcode.TreeNode;

public class H124_Binary_Tree_Maximum_Path_Sum {

	int maxValue;

	public int maxPathSum(TreeNode root) {
		maxValue = Integer.MIN_VALUE;
		maxPathDown(root);
		return maxValue;
	}

	private int maxPathDown(TreeNode node) {
		if (node == null)
			return 0;
		int left = Math.max(0, maxPathDown(node.left));
		int right = Math.max(0, maxPathDown(node.right));
		maxValue = Math.max(maxValue, left + right + node.val);
		return Math.max(left, right) + node.val;
	}
}
