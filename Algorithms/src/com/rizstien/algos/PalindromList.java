package com.rizstien.algos;

import java.util.Stack;

public class PalindromList {
	class ListNode {
		public int val;
		public ListNode next;
		ListNode(int x) { val = x; next = null; }
	}
	
	public int lPalin(ListNode A) {
        Stack<Integer> stk = new Stack<Integer>();
        ListNode curr = A;
        while(curr!=null){
            stk.push(curr.val);
            curr = curr.next;
        }
        curr=A;
        while(curr!=null){
            if(curr.val!=stk.pop()) return 0;
            curr=curr.next;
        }
        return 1;
    }
}
