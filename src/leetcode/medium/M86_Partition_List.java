package leetcode.medium;

import leetcode.ListNode;

public class M86_Partition_List {
	public ListNode partition(ListNode head, int x) {
		if (head == null)
			return head;
		ListNode less = new ListNode(0);
		ListNode greater = new ListNode(0);
		ListNode p1 = less;
		ListNode p2 = greater;
		ListNode p = head;

		while (p != null) {
			if (p.val < x) {
				ListNode t = new ListNode(p.val);
				p1.next = t;
				p1 = p1.next;
			} else if (p.val >= x) {
				ListNode t = new ListNode(p.val);
				p2.next = t;
				p2 = p2.next;
			}

			p = p.next;
		}
		p1.next = greater.next;

		return less.next;

	}
}
