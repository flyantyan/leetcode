package leetcode.easy;

import leetcode.TreeNode;

public class E235_Lowest_Common_Ancestor_of_a_Binary_Search_Tree {

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		while ((root.val - p.val) * (root.val - q.val) > 0)
			root = p.val < root.val ? root.left : root.right;
		return root;
	}
}
