package leetcode.easy;

import leetcode.ListNode;

public class E160_Intersection_of_Two_Linked_Lists {

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null)
			return null;
		int lenA = 0;
		int lenB = 0;

		ListNode pA = headA;
		while (pA != null) {
			lenA++;
			pA = pA.next;
		}

		ListNode pB = headB;
		while (pB != null) {
			pB = pB.next;
			lenB++;
		}

		int len = 0;
		pA = headA;
		pB = headB;
		if (lenA > lenB) {
			len = lenA - lenB;
			pA = headA;
			pB = headB;
		} else if (lenA < lenB) {
			len = lenB - lenA;
			pA = headB;
			pB = headA;
		}
		while (len > 0) {
			len--;
			pA = pA.next;
		}

		while (pA != null && pB != null) {
			if (pA == pB)
				return pB;
			else {
				pA = pA.next;
				pB = pB.next;
			}
		}

		return null;
	}
	
	public static void main(String[] args) {
		new E160_Intersection_of_Two_Linked_Lists().getIntersectionNode(new ListNode(1) , new ListNode(1));
	}
}
