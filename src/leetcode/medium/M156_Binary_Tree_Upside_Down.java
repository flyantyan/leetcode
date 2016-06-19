package leetcode.medium;

import leetcode.TreeNode;

public class M156_Binary_Tree_Upside_Down {

	public TreeNode upsideDownBinaryTree(TreeNode root) {
		if (root == null || root.left == null && root.right == null)
			return root;

		TreeNode newRoot = upsideDownBinaryTree(root.left);

		root.left.left = root.right;
		root.left.right = root;

		root.left = null;
		root.right = null;

		return newRoot;
	}
}
