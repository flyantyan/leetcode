package leetcode.easy;

import leetcode.ListNode;

public class E83_Remove_Duplicates_from_Sorted_List {

	public ListNode deleteDuplicates1(ListNode head) {
		if (head == null)
			return head;

		ListNode dummy = head;
		while (dummy.next != null) {
			if (dummy.next.val == dummy.val) {
				dummy.next = dummy.next.next;
			} else
				dummy = dummy.next;
		}
		return head;

	}

	public ListNode deleteDuplicates(ListNode head) {
		if (head == null)
			return head;

		ListNode result = new ListNode(0);
		ListNode temp = new ListNode(head.val);
		result.next = temp;
		temp.next = null;

		ListNode p = head;

		while (p != null) {
			if (p.val != temp.val) {
				ListNode t = new ListNode(p.val);
				temp.next = t;
				temp = temp.next;
				temp.next = null;
			}
			p = p.next;
		}

		return result.next;

	}

	public static void main(String[] args) {
		new E83_Remove_Duplicates_from_Sorted_List()
				.deleteDuplicates(ListNode.getInstance(new int[] { 1, 1, 2, 2, 2 }));
	}
}
