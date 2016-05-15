package leetcode.easy;

import leetcode.TreeNode;

public class E226_Invert_Binary_Tree {

	public TreeNode invertTree(TreeNode root) {
		if (root == null)
			return root;

		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;

		invertTree(root.left);
		invertTree(root.right);

		return root;
	}
}
