package leetcode.easy;

import leetcode.TreeNode;

public class E100_Same_Tree {

	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null)
			return q == null;
		if (q == null)
			return p == null;

		if (p.val != q.val)
			return false;

		return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	}
}
