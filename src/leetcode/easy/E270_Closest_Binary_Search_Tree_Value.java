package leetcode.easy;

import leetcode.TreeNode;

public class E270_Closest_Binary_Search_Tree_Value {

	public int closestValue(TreeNode root, double target) {
		int a = root.val;
		TreeNode kid = target < a ? root.left : root.right;
		if (kid == null)
			return a;
		int b = closestValue(kid, target);
		return Math.abs(a - target) < Math.abs(b - target) ? a : b;
	}
}
