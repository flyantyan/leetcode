package leetcode.medium;

import leetcode.TreeNode;

public class M285_Inorder_Successor_in_BST {

	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
		if (root == null || p == null)
			return null;
		if (root.val <= p.val) {
			return inorderSuccessor(root.right, p);
		} else {
			TreeNode left = inorderSuccessor(root.left, p);
			return (left != null) ? left : root;
		}
	}
}
