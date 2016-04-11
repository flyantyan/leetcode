package leetcode.easy;

import leetcode.ListNode;

public class E19_Remove_Nth_Node_From_End_of_List {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode slow = head, fast = head;

		while (n-- > 0) {
			if (fast == null)
				break;
			fast = fast.next;
		}

		// if(n > 0){
		// return null;
		// }

		if (fast == null)
			return head.next;

		ListNode p = null;
		while (fast != null) {
			p = slow;
			slow = slow.next;
			fast = fast.next;
		}

		p.next = slow.next;

		return head;
	}

	public static void main(String[] args) {
		new E19_Remove_Nth_Node_From_End_of_List().removeNthFromEnd(ListNode.getInstance(new int[] { 1, 2 }), 2);
	}
}
