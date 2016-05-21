package leetcode.medium;

import leetcode.ListNode;

public class M328_Odd_Even_Linked_List {

	public ListNode oddEvenList(ListNode head) {
		if (head == null)
			return null;

		ListNode odd = head, even = head.next, evenHead = even;
		while (even != null && even.next != null) {
			odd.next = odd.next.next;
			even.next = even.next.next;
			odd = odd.next;
			even = even.next;
		}

		odd.next = evenHead;

		return head;
	}
}
