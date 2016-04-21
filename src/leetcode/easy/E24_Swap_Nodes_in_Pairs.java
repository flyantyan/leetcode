package leetcode.easy;

import leetcode.ListNode;

public class E24_Swap_Nodes_in_Pairs {

	
	public ListNode swapPairs(ListNode head) {
		ListNode result = new ListNode(0);
		result.next = head;
		ListNode current = result;

		while (current.next != null && current.next.next != null) {
			ListNode first = current.next;
			ListNode second = current.next.next;

			first.next = second.next;
			current.next = second;
			current.next.next = first;
			current = current.next.next;
		}

		return result.next;
	}
}
