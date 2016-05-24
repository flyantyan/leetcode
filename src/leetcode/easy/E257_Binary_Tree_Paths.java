package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

import leetcode.TreeNode;

public class E257_Binary_Tree_Paths {

	public List<String> binaryTreePaths(TreeNode root) {
		List<String> result = new ArrayList<>();
		if (root == null)
			return result;
		searchTree(root, "", result);
		return result;
	}

	private void searchTree(TreeNode root, String str, List<String> result) {
		if (root.left == null && root.right == null) {
			result.add(str + root.val);
			return;
		}

		if (root.left != null) {
			searchTree(root.left, str + root.val + "->", result);
		}
		if (root.right != null) {
			searchTree(root.right, str + root.val + "->", result);
		}
	}
}
