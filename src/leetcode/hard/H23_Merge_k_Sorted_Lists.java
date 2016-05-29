package leetcode.hard;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

import leetcode.ListNode;

public class H23_Merge_k_Sorted_Lists {

	public ListNode mergeKLists(ListNode[] lists) {
		if (lists == null || lists.length == 0)
			return null;
		Queue<ListNode> heap = new PriorityQueue(new Comparator<ListNode>() {
			@Override
			public int compare(ListNode l1, ListNode l2) {
				return l1.val - l2.val;
			}
		});

		ListNode head = new ListNode(0);
		ListNode temp = head;

		for (ListNode node : lists) {
			if (node != null) {
				heap.offer(node);
			}
		}

		while (!heap.isEmpty()) {
			temp.next = heap.poll();
			temp = temp.next;
			if (temp.next != null) {
				heap.offer(temp.next);
			}
		}

		return head.next;
	}
}
