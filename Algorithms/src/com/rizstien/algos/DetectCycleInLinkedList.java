package com.rizstien.algos;

import java.util.HashSet;
import java.util.Set;

public class DetectCycleInLinkedList {
	class ListNode {
		public int val;
		public ListNode next;
		ListNode(int x) { val = x; next = null; }
	}
	
    public ListNode detectCycle(ListNode a) {
        Set<ListNode> nodes = new HashSet<ListNode>();
        ListNode curr = a;
        while(curr.next!=null){
            if(nodes.contains(curr)) return curr;
            nodes.add(curr);
            curr = curr.next;
        }
        return null;
    }
}
