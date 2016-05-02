package leetcode.medium;

import leetcode.ListNode;

public class M61_Rotate_List {

	public ListNode rotateRight(ListNode head, int k) {
		if (head == null)
			return head;

		int len = 0;
		ListNode temp = head;
		ListNode end = null;
		while (temp != null) {
			end = temp;
			temp = temp.next;
			len++;
		}

		if (k % len == 0)
			return head;
		k %= len;

		int m = len - k - 1;
		temp = head.next;
		ListNode pre = head;
		while (m > 0) {
			pre = pre.next;
			temp = temp.next;
			m--;
		}

		pre.next = null;
		end.next = head;

		return temp;

	}
	
	public static void main(String[] args) {
		new M61_Rotate_List().rotateRight( ListNode.getInstance(new int[]{1,2,3,4}) ,2);
	}
}
