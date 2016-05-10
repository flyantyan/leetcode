package leetcode.easy;

import leetcode.TreeNode;

public class E110_Balanced_Binary_Tree {

	public boolean isBalanced(TreeNode root) {
		if (root == null)
			return true;
		if (Math.abs(heigh(root.left) - heigh(root.right)) <= 1)
			return isBalanced(root.left) && isBalanced(root.right);
		return false;

	}

	private int heigh(TreeNode root) {
		if (root == null)
			return 0;

		return Math.max(heigh(root.left), heigh(root.right)) + 1;
	}
}
