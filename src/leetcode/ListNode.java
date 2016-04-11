package leetcode;

public class ListNode {

	public int val;
	public ListNode next;

	public ListNode(int x) {
		val = x;
	}
	
	public static ListNode getInstance(int[]num){
		if(num.length == 0)
			return null ;
		
		ListNode head = new ListNode(num[0]);
		
		ListNode p = head ;
		
		for(int i = 1 ; i < num.length ; i ++){
			p.next = new ListNode(num[i]);
		}
		
		return head ;
		
		
		
	}
}
