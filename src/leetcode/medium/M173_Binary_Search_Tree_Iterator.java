package leetcode.medium;

import java.util.Stack;

import leetcode.TreeNode;

public class M173_Binary_Search_Tree_Iterator {

	private Stack<TreeNode> stack = new Stack<TreeNode>();

	public M173_Binary_Search_Tree_Iterator(TreeNode root) {
		pushAll(root);
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return !stack.isEmpty();
	}

	/** @return the next smallest number */
	public int next() {
		TreeNode tmpNode = stack.pop();
		pushAll(tmpNode.right);
		return tmpNode.val;
	}

	private void pushAll(TreeNode node) {
		for (; node != null; stack.push(node), node = node.left)
			;
	}
}
