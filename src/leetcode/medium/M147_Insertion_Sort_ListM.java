package leetcode.medium;

import leetcode.ListNode;

public class M147_Insertion_Sort_ListM {
	public ListNode insertionSortList(ListNode head) {
		if (head == null)
			return head;

		ListNode p = head.next;

		while (p != null) {
			ListNode t = head;
			while (t != p) {
				if (p.val < t.val) {
					// swap
					// p.next = t.next ;
					// t.next = p ;
					int temp = t.val;
					t.val = p.val;
					p.val = temp;
				}
				t = t.next;
			}
			p = p.next;
		}
		return head;
	}
}
