package com.rizstien.algos;

public class ReverseSublist2 {
	class ListNode {
		public int val;
		public ListNode next;
		ListNode(int x) { val = x; next = null; }
	}
	
	public ListNode reverseBetween(ListNode n, int M, int N) {
		ListNode A=null,B=null,C=null,D=null;
        ListNode curr = n;
        int count=1;
        
        if(curr.next==null) return n;

        while(curr.next!=null){
            if(M==1){
                B=n;
            }
            if(count+1==M){
                A=curr;
                B=curr.next;
            }else if(count==N){
                C=curr;
                D=curr.next;
                System.out.println("D: "+D.val);
            }
            curr=curr.next;
            count++;
        }
        
        if(M==1){
            n=reverseList(B,D);
        }else{
            A.next=reverseList(B,D);
        }
        B.next=D;
        return n;
    }
    
    ListNode reverseList(ListNode start, ListNode end){
        ListNode next=null;
        ListNode prev=null;
        ListNode curr = start;
        while(curr!=end){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }

}
