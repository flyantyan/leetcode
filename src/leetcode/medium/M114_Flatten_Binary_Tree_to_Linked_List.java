package leetcode.medium;

import leetcode.TreeNode;

public class M114_Flatten_Binary_Tree_to_Linked_List {

	public void flatten(TreeNode root) {
		if (root == null)
			return;
		flatten(root, null);
	}

	private TreeNode flatten(TreeNode root, TreeNode pre) {
		if (root == null)
			return pre;

		root.right = flatten(root.left, flatten(root.right, pre));
		root.left = null;

		return root;
	}
}
