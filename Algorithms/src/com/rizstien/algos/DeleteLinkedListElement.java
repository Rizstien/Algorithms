package com.rizstien.algos;

public class DeleteLinkedListElement {
	static class Node{
		int val;
		Node next;
		Node(int val){
			this.val = val;
			this.next=null;
		}
	}
	
	public static Node delete(Node head) {
		while(head!=null && head.val==0) head = head.next;
		
		Node curr = head;
		while(curr!=null && curr.next!=null) {
			if(curr.next.val==0) {
				Node temp = curr.next;
				curr.next = curr.next.next;
				temp=null;
			}else {
				curr = curr.next;
			}
		}
		return head;
	}
	
	static Node insert(Node head, int val){
		if(head==null) {
			head = new Node(val);
			return head;
		}
		Node curr = head;
		while(curr.next!=null) {
			curr=curr.next;
		}
		curr.next = new Node(val);
		return head;
	}
	
	static void printList(Node node) { 
		 while (node != null) { 
			 System.out.print(node.val + " "); 
	         node = node.next; 
	     } 
	 } 
	
	public static void main(String[] args) {
		Node head=null;
		head = insert(head,0);
		head = insert(head,1);
		head = insert(head,0);
		head = insert(head,0);
		head = insert(head,0);
		head = insert(head,3);
		head = delete(head);
		printList(head);
		
	}

}
