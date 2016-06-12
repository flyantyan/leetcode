package leetcode.hard;

import leetcode.RandomListNode;

public class H138_Copy_List_with_Random_Pointer {

	// step1 create add new note into original list
	// step 2 populate random pointer of new list
	// step3 seperate old list and new list
	public RandomListNode copyRandomList(RandomListNode head) {
		if (head == null)
			return head;
		RandomListNode p = head;
		while (p != null) {
			RandomListNode temp = new RandomListNode(p.label);
			temp.next = p.next;

			p.next = temp;
			p = p.next.next;
		}

		p = head;
		while (p != null) {
			RandomListNode current = p.next;
			if (p.random != null)
				current.random = p.random.next;
			p = p.next.next;
		}
		RandomListNode newHead = head.next;
		p = newHead;
		RandomListNode t = head;
		while (t != null) {
			RandomListNode current = t.next;
			t.next = t.next.next;
			t = t.next;
			if (t != null)
				current.next = t.next;
		}

		return newHead;
	}
}
