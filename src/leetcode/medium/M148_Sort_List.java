package leetcode.medium;

import leetcode.ListNode;

public class M148_Sort_List {

	public ListNode sortList(ListNode head) {
		// Merge Sort
		if (head == null || head.next == null)
			return head;

		// Find the middle node by slow quick point
		ListNode slow = head;
		ListNode quick = head;
		while (quick.next != null && quick.next.next != null) {
			slow = slow.next;
			quick = quick.next.next;
		}
		quick = slow;
		slow = slow.next;
		quick.next = null;
		ListNode h1 = sortList(head);
		ListNode h2 = sortList(slow);

		return mergeTwoList(h1, h2);

	}

	private ListNode mergeTwoList(ListNode h1, ListNode h2) {
		ListNode dump = new ListNode(0);
		for (ListNode t = dump; h1 != null || h2 != null; t = t.next) {
			int val1 = (h1 == null ? Integer.MAX_VALUE : h1.val);
			int val2 = (h2 == null ? Integer.MAX_VALUE : h2.val);

			if (val1 < val2) {
				t.next = h1;
				h1 = h1.next;
			} else {
				t.next = h2;
				h2 = h2.next;
			}
		}
		return dump.next;
	}
}
