package leetcode.easy;

import leetcode.ListNode;

public class E206_Reverse_Linked_List {

	public ListNode reverseList(ListNode head) {
		ListNode p = head;
		ListNode newHead = null;
		while (p != null) {
			ListNode next = p.next;
			p.next = newHead;
			newHead = p;
			p = next;
		}
		return newHead;
	}

	public ListNode reverseList(ListNode head, ListNode newHead) {
		if (head == null)
			return newHead;

		ListNode next = head.next;
		head.next = newHead;

		return reverseList(next, head);
	}
}
