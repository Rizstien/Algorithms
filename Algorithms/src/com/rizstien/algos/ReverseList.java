package com.rizstien.algos;

public class ReverseList {
	 class ListNode {
		 public int val;
		 public ListNode next;
		 ListNode(int x) { val = x; next = null; }
	}
	 
    public ListNode reverseList(ListNode A) {
        ListNode next=null;
        ListNode prev=null;
        ListNode curr=A;
        return reverseList(curr,next,prev);
    }
    
    public ListNode reverseList(ListNode curr,ListNode next,ListNode prev){
        if(curr==null) return prev;
        else{
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return reverseList(curr,next,prev);
    }
}
