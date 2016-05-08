package leetcode.medium;

import leetcode.ListNode;

public class M92_Reverse_Linked_List_II {

	public ListNode reverseBetween_1(ListNode head, int m, int n) {
	    if(head == null) return null;
	    ListNode dummy = new ListNode(0); // create a dummy node to mark the head of this list
	    dummy.next = head;
	    ListNode pre = dummy; // make a pointer pre as a marker for the node before reversing
	    for(int i = 0; i<m-1; i++) pre = pre.next;

	    ListNode start = pre.next; // a pointer to the beginning of a sub-list that will be reversed
	    ListNode then = start.next; // a pointer to a node that will be reversed

	    // 1 - 2 -3 - 4 - 5 ; m=2; n =4 ---> pre = 1, start = 2, then = 3
	    // dummy-> 1 -> 2 -> 3 -> 4 -> 5

	    for(int i=0; i<n-m; i++)
	    {
	        start.next = then.next;
	        then.next = pre.next;
	        pre.next = then;
	        then = start.next;
	    }

	    // first reversing : dummy->1 - 3 - 2 - 4 - 5; pre = 1, start = 2, then = 4
	    // second reversing: dummy->1 - 4 - 3 - 2 - 5; pre = 1, start = 2, then = 5 (finish)

	    return dummy.next;

	}
	
	
	public ListNode reverseBetween(ListNode head, int m, int n) {
        if( m == n)
            return head ;
        
        
        if(head == null) return null;
        ListNode dummy = new ListNode(0); // create a dummy node to mark the head of this list
        dummy.next = head;
        ListNode pre = dummy; // make a pointer pre as a marker for the node before reversing
        for(int i = 0; i<m-1; i++) pre = pre.next;
        
        n-=m ;
        
        ListNode start = pre.next;
        ListNode newHead = null ;
        ListNode p = start ;
        ListNode then = start.next ;
        while(n >= 0 && p != null){
            then = p.next ;
            p.next = newHead ;
            newHead = p ;
            p = then ;
            n-- ;
        }
        
        pre.next = newHead ;
        start.next = then ;
        
        return dummy.next ;
    }
}
