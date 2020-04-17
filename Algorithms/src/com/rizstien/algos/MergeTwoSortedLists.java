package com.rizstien.algos;

public class MergeTwoSortedLists {
	class ListNode {
		public int val;
		public ListNode next;
		ListNode(int x) { val = x; next = null; }
	}
	
	public ListNode mergeTwoLists(ListNode A, ListNode B) {
        ListNode result = null,last=null;
        ListNode a = A;
        ListNode b = B;
        
        if(a.val<b.val){
            result = new ListNode(a.val);
            last=result;
            a=a.next;
        } else {
            result = new ListNode(b.val);
            last=result;
            b=b.next;
        }
        
        while(a!=null && b!=null){
            if(a.val<b.val){
                last = insert(a.val,last);
                a=a.next;
            }else{
                last = insert(b.val,last);
                b=b.next;
            }
        }
        
        while(a!=null){
            last = insert(a.val,last);
            a=a.next;
        }
        
        while(b!=null){
            last = insert(b.val,last);
            b=b.next;
        }
        
        return result;
    }
    
    ListNode insert(int val, ListNode last){
        ListNode node = new ListNode(val);
        last.next=node;
        last=last.next;
        return last;
    }
}
