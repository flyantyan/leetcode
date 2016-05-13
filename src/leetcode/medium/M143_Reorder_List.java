package leetcode.medium;

import leetcode.ListNode;

public class M143_Reorder_List {
	public void reorderList(ListNode head) {
		// Three steps
		// 1. find the middle of the list , split to two
		// 2. reverse after the middle
		// 3. merge two list

		if (head == null)
			return;
		ListNode quick = head;
		ListNode low = head;

		while (quick != null && quick.next != null) {
			low = low.next;
			quick = quick.next.next;
		}
		// Find the middle of the list
		ListNode middle = low;
		ListNode p = low.next;
		ListNode newHead = null;
		while (p != null) {
			ListNode next = p.next;
			p.next = newHead;
			newHead = p;
			p = next;
		}
		middle.next = null;
		ListNode p1 = head;
		ListNode p2 = newHead;

		while (p2 != null) {
			ListNode next1 = p1.next;
			ListNode next2 = p2.next;
			p1.next = p2;
			p2.next = next1;
			p1 = next1;
			p2 = next2;
		}

	}
}
