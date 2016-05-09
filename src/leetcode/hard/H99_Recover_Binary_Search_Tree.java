package leetcode.hard;

import leetcode.TreeNode;

public class H99_Recover_Binary_Search_Tree {
	private TreeNode firstElement = null;
	private TreeNode secondElement = null;
	private TreeNode preElement = new TreeNode(Integer.MIN_VALUE);

	public void recoverTree(TreeNode root) {

		traverse(root);

		int temp = firstElement.val;
		firstElement.val = secondElement.val;
		secondElement.val = temp;

	}

	private void traverse(TreeNode root) {
		if (root == null)
			return;

		traverse(root.left);

		if (firstElement == null && preElement.val >= root.val) {
			firstElement = preElement;
		}

		if (firstElement != null && preElement.val >= root.val) {
			secondElement = root;
		}
		preElement = root;
		traverse(root.right);
	}
}
