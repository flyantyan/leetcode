package leetcode.medium;

import leetcode.TreeNode;

public class M250_Count_Univalue_Subtrees {

	// post order
	public int countUnivalSubtrees(TreeNode root) {
		int count[] = new int[1];
		isUnivalSubtrees(root, count);
		return count[0];
	}

	private boolean isUnivalSubtrees(TreeNode root, int[] count) {

		if (root == null)
			return true;

		boolean left = isUnivalSubtrees(root.left, count);
		boolean right = isUnivalSubtrees(root.right, count);

		if (left && right) {
			if (root.left != null && root.left.val != root.val)
				return false;
			if (root.right != null && root.right.val != root.val)
				return false;
			count[0]++;
			return true;
		}

		return false;
	}
}
