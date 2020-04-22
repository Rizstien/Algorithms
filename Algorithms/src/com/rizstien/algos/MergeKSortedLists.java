package com.rizstien.algos;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {
	class ListNode {
		public int val;
		public ListNode next;
		ListNode(int x) { val = x; next = null; }
	}
	
	public ListNode mergeKLists(ArrayList<ListNode> a) {
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(10, new Comparator<ListNode>() {
            public int compare(ListNode n1, ListNode n2) {                         
                return n1.val - n2.val;  
            }      
        });  
        ListNode result = null;
        for(int i=0;i<a.size();i++){
            ListNode node = a.get(i); 
            pq.add(node);
        }
        
        while(!pq.isEmpty()){
            ListNode node = pq.remove();
            result = insert(result,node.val);
            node = delete(node);
            if(node!=null)
                pq.add(node);
        }
        
        return result;
    }
    
    public ListNode delete(ListNode a){
        ListNode temp = null;
        temp = a;
        a = a.next;
        temp.next = null;
        return a;
    }
    
    public ListNode insert(ListNode a, int val){
        ListNode node = new ListNode(val);
        if(a==null){
            a=node;
        }else{
            ListNode curr = a; 
            while(curr.next!=null){
                curr = curr.next;
            }
            curr.next = node;
        }
        return a;
    }
}
