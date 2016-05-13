package leetcode.easy;

import leetcode.ListNode;

public class E141_Linked_List_Cycle {

	public boolean hasCycle(ListNode head) {
        ListNode low = head ;
        ListNode quick = head ;
        
        while(quick != null && quick.next != null){
            low = low.next ;
            quick = quick.next.next ;
            if(low == quick)
                return true ;
        }
        
        return false ;
    }
}
