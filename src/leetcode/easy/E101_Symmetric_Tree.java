package leetcode.easy;

import leetcode.TreeNode;

public class E101_Symmetric_Tree {

	public boolean isSymmetric(TreeNode root) {

		return root == null || isSymmetric(root.left, root.right);
	}

	private boolean isSymmetric(TreeNode left, TreeNode right) {
		if (left == null || right == null)
			return left == right;

		if (left.val != right.val)
			return false;

		return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
	}
}
