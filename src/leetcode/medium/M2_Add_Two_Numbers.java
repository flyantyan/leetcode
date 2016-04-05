package leetcode.medium;

import leetcode.ListNode;

/**
 * 
 * 
 * TestCase: 1. [0] [7,3]
 * 
 * @author yanfei
 *
 */
public class M2_Add_Two_Numbers {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(2);
		ListNode l2 = new ListNode(4);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(5);
		ListNode l5 = new ListNode(6);
		ListNode l6 = new ListNode(4);

		l1.next = l2;
		l2.next = l3;

		l4.next = l5;
		l5.next = l6;

		addTwoNumbers(l1, l4);
	}

	/**
	 * 
	 * Assume： We can not change the input value , so we should use the space of
	 * input value for result. First should new ListNode
	 * 
	 * Thought: 1. new ListNode for space to store the result 2. Because the
	 * digits are stored in reverse order ,so we add each digit from the start
	 * of ListNode 2.1 Use tmp to store the carry bit 3. Judge each of the input
	 * ListNodes has reached the end , if not ,assign the remain bit to result
	 * directly Note: Do not forget the tmp
	 */
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;
		ListNode result = null;
		ListNode lp1 = l1;
		ListNode lp2 = l2;
		ListNode lr = null;
		/** store the carry bit */
		int tmp = 0;

		while (lp1 != null && lp2 != null) {
			int r = lp1.val + lp2.val + tmp;
			tmp = r / 10;
			r = r % 10;
			ListNode node = new ListNode(r);

			if (result == null) {
				result = node;
				lr = result;
			} else {
				lr.next = node;
				lr = lr.next;
			}

			lp1 = lp1.next;
			lp2 = lp2.next;
		}

		while (lp1 != null) {
			int r = lp1.val + tmp;
			tmp = r / 10;
			r = r % 10;

			ListNode node = new ListNode(r);

			lr.next = node;
			lr = lr.next;
			lp1 = lp1.next;
		}

		while (lp2 != null) {
			int r = lp2.val + tmp;
			tmp = r / 10;
			r = r % 10;

			ListNode node = new ListNode(r);
			lr.next = node;
			lr = lr.next;
			lp2 = lp2.next;
		}

		if (tmp > 0) {
			ListNode node = new ListNode(tmp);
			lr.next = node;
		}

		return result;
	}
	
	//TODO: Other method to solve the problem
	//TODO:

}
