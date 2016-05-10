package leetcode.medium;

import leetcode.TreeNode;

public class M108_Convert_Sorted_Array_to_Binary_Search_Tree {

	public TreeNode sortedArrayToBST(int[] nums) {
		return generate(nums, 0, nums.length - 1);
	}

	private TreeNode generate(int[] nums, int start, int end) {
		if (start > end)
			return null;
		int mid = start + (end - start) / 2;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = generate(nums, start, mid - 1);
		root.right = generate(nums, mid + 1, end);

		return root;
	}
}
