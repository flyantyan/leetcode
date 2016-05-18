package leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import leetcode.TreeNode;

public class M145_Binary_Tree_Postorder_Traversal {

	// Iterative solution
	public List<Integer> postorderTraversal(TreeNode root) {
		LinkedList<Integer> result = new LinkedList<>();
		if (root == null)
			return result;

		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);

		while (!stack.isEmpty()) {
			TreeNode temp = stack.pop();
			result.addFirst(temp.val);
			if (temp.left != null) {
				stack.push(temp.left);
			}
			if (temp.right != null) {
				stack.push(temp.right);
			}
		}

		return result;
	}

	// Recursive solution
	public List<Integer> postorderTraversal_recursive(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if (root == null)
			return result;

		result.addAll(postorderTraversal(root.left));
		result.addAll(postorderTraversal(root.right));
		result.add(root.val);

		return result;
	}
}
