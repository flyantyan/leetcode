package leetcode.medium;

import leetcode.ListNode;

public class M82_Remove_Duplicates_from_Sorted_ListII {

	//No extra space
	public ListNode deleteDuplicates(ListNode head) {
		ListNode cur = head;
		ListNode pre = null;
		while (cur != null && cur.next != null) {
			if (cur.val == cur.next.val) {
				// this part is used for deleting duplicate node
				while (cur.next != null && cur.val == cur.next.val) {
					cur = cur.next;
				}
				if (pre != null) {
					pre.next = cur.next;
				} else {
					head = cur.next;
				}
				cur = cur.next;
			} else if (cur != null) {
				// this part is for non-duplicate node
				pre = cur;
				cur = cur.next;
			}
		}
		return head;
	}

	//Use extra space
	public ListNode deleteDuplicates1(ListNode head) {
		if (head == null)
			return head;

		ListNode p = head;

		ListNode result = new ListNode(0);
		ListNode temp = result;

		while (p != null) {
			if (p.next == null || p.val != p.next.val) {
				ListNode t = new ListNode(p.val);
				temp.next = t;
				temp = temp.next;
				p = p.next;
			} else if (p.val == p.next.val) {
				int val = p.val;
				while (p != null && p.val == val) {
					p = p.next;
				}
			}
		}

		return result.next;
	}
}
