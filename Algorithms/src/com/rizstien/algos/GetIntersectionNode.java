package com.rizstien.algos;

public class GetIntersectionNode {
	class ListNode {
		public int val;
		public ListNode next;
		ListNode(int x) { val = x; next = null; }
	}
	
	public ListNode getIntersectionNode(ListNode a, ListNode b) {
        int n = findLength(a);
        int m = findLength(b);
        int d=n-m;
        ListNode currA = a;
        ListNode currB = b;
        
        if(m>n){
            d=m-n;
            for(int i=0;i<d;i++){
                currB=currB.next;
            }
        }else if(n>m){
            for(int i=0;i<d;i++){
                currA=currA.next;
            }
        }
        
        while(currA!=null && currB!=null){
            if(currA==currB) return currA;
            currA=currA.next;
            currB=currB.next;
        }
        
        return null;
        
    }
    
    public int findLength(ListNode n){
        int length = 0;
        ListNode curr = n;
        while(curr!=null){
            length++;
            curr = curr.next;
        }
        return length;
    }

}
