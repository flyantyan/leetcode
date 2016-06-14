package leetcode.medium;

import leetcode.ListNode;
import leetcode.TreeNode;

public class M109_Convert_Sorted_List_to_Binary_Search_Tree {

	public TreeNode sortedListToBST(ListNode head) {
		if (head == null)
			return null;
		int len = 0;
		ListNode p = head;
		while (p != null) {
			p = p.next;
			len++;
		}
		this.head = head;
		return sortedListToBST(0, len - 1);
	}

	private ListNode head;

	private TreeNode sortedListToBST(int start, int end) {
		if (start > end)
			return null;
		int mid = start + (end - start) / 2;
		TreeNode left = sortedListToBST(start, mid - 1);
		TreeNode root = new TreeNode(head.val);
		head = head.next;
		TreeNode right = sortedListToBST(mid + 1, end);
		root.left = left;
		root.right = right;

		return root;
	}
}
