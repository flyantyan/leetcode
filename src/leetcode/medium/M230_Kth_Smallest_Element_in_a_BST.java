package leetcode.medium;

import java.util.Stack;

import leetcode.TreeNode;

public class M230_Kth_Smallest_Element_in_a_BST {

	public int kthSmallest(TreeNode root, int k) {
		if (root == null)
			return 0;

		Stack<TreeNode> stack = new Stack<>();
		TreeNode t = root;
		int count = 0;
		while (!stack.isEmpty() || t != null) {
			if (t != null) {
				stack.push(t);
				t = t.left;
			} else {
				TreeNode node = stack.pop();
				if (++count == k)
					return node.val;
				t = node.right;
			}
		}
		return 0;
	}
}
