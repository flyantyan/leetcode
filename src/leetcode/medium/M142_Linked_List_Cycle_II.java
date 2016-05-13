package leetcode.medium;

import leetcode.ListNode;

public class M142_Linked_List_Cycle_II {

	public ListNode detectCycle(ListNode head) {
        ListNode low = head ;
        ListNode quick = head ;
        
        while(quick != null && quick.next != null){
            low = low.next ;
            quick = quick.next.next ;
            
            if(low == quick){
                low = head ;
                while(true){
                    if(low == quick)
                        return low ;
                    low = low.next ;
                    quick = quick.next;
                }
            }
        }
        
        return null ;
    }
}
