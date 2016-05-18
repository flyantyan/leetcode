package leetcode.medium;

import leetcode.TreeNode;

public class M106_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal {

	public TreeNode buildTree(int[] inorder, int[] postorder) {
		if (inorder == null || postorder == null)
			return null;
		return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
	}

	private TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
		if (inEnd < inStart || postEnd < 0 || postStart > postEnd)
			return null;

		TreeNode root = new TreeNode(postorder[postEnd]);
		int rootIndex = -1;
		for (int i = inStart; i <= inEnd; i++) {
			if (inorder[i] == postorder[postEnd]) {
				rootIndex = i;
				break;
			}
		}
		root.left = buildTree(inorder, inStart, rootIndex - 1, postorder, postStart,
				postStart + rootIndex - inStart - 1);
		root.right = buildTree(inorder, rootIndex + 1, inEnd, postorder, postStart + rootIndex - inStart, postEnd - 1);

		return root;
	}
}
