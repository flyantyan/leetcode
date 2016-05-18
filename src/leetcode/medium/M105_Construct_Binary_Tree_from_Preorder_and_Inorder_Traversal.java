package leetcode.medium;

import leetcode.TreeNode;

public class M105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder == null || inorder == null)
			return null;

		TreeNode root = buildTree(preorder, 0, inorder, 0, inorder.length - 1);
		return root;
	}

	private TreeNode buildTree(int[] preorder, int preStart, int[] inorder, int inStart, int inEnd) {
		if (inStart > inEnd || preStart > preorder.length - 1) {
			return null;
		}
		TreeNode root = new TreeNode(preorder[preStart]);
		int index = findNum(inorder, inStart, inEnd, preorder[preStart]);

		root.left = buildTree(preorder, preStart + 1, inorder, inStart, index - 1);
		root.right = buildTree(preorder, preStart + 1 + index - inStart, inorder, index + 1, inEnd);

		return root;
	}

	private int findNum(int[] nums, int start, int end, int target) {
		for (int i = start; i <= end; i++) {
			if (nums[i] == target)
				return i;
		}
		return -1;
	}
}
