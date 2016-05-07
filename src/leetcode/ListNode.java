package leetcode;

public class ListNode {

	public int val;
	public ListNode next;

	public ListNode(int x) {
		val = x;
	}

	public static ListNode getInstance(int[] num) {
		if (num.length == 0)
			return null;

		ListNode head = new ListNode(0);
		head.next = null;
		ListNode t = head;

		for (int i = 0; i < num.length; i++) {
			ListNode temp = new ListNode(num[i]);
			t.next = temp;
			t = temp;
		}

		return head.next;

	}
}
