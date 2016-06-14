package leetcode.medium;

import leetcode.TreeNode;

public class M222_Count_Complete_Tree_Nodes {

	// Refact
	public int countNodes_1(TreeNode root) {
		if (root == null)
			return 0;
		TreeNode left = root, right = root;
		int height = 0;
		while (right != null) {
			left = left.left;
			right = right.right;
			height++;
		}
		if (left == null)
			return (1 << height) - 1;
		return 1 + countNodes(root.left) + countNodes(root.right);
	}

	// Steps to solve this problem:
	// 1) get the height of left-most part
	// 2) get the height of right-most part
	// 3) when they are equal, the # of nodes = 2^h -1
	// 4) when they are not equal, recursively get # of nodes from left&right
	// sub-trees
	// http://www.programcreek.com/2014/06/leetcode-count-complete-tree-nodes-java/
	public int countNodes(TreeNode root) {
		if (root == null)
			return 0;
		int left = getLeftHeight(root);
		int right = getRightHeight(root);
		if (left == right)
			return (2 << (left - 1)) - 1;
		else
			return countNodes(root.left) + countNodes(root.right) + 1;
	}

	private int getLeftHeight(TreeNode node) {
		int count = 0;
		while (node != null) {
			count++;
			node = node.left;
		}
		return count;
	}

	private int getRightHeight(TreeNode node) {
		int count = 0;
		while (node != null) {
			node = node.right;
			count++;
		}
		return count;
	}
}
