package leetcode.easy;

import leetcode.ListNode;

public class E21_Merge_Two_Sorted_Lists {

	public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}

		ListNode head = null;
		ListNode temp = null;
		while (l1 != null && l2 != null) {
			int num;
			if (l1.val < l2.val) {
				num = l1.val;
				l1 = l1.next;
			} else {
				num = l2.val;
				l2 = l2.next;
			}
			if (head == null) {
				head = new ListNode(num);
				temp = head;
			} else {
				temp.next = new ListNode(num);
				temp = temp.next;
			}

		}

		while (l1 != null) {
			temp.next = new ListNode(l1.val);
			temp = temp.next;
			l1 = l1.next;
		}

		while (l2 != null) {
			temp.next = new ListNode(l2.val);
			temp = temp.next;
			l2 = l2.next;
		}

		return head;
	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}

		ListNode mergeHead;
		if (l1.val < l2.val) {
			mergeHead = l1;
			mergeHead.next = mergeTwoLists(l1.next, l2);
		} else {
			mergeHead = l2;
			mergeHead.next = mergeTwoLists(l1, l2.next);
		}
		return mergeHead;
	}
}
