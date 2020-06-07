package com.rizstien.algos;

public class BSTToDLL {
	static class Node{
		int val;
		Node left,right;
		Node(int val){
			this.val=val;
			left=null;
			right=null;
		}
	}

	Node prev = null;
	Node head = null;
	public void BSTToDLL(Node root) {
		if(root==null) return;
		
		BSTToDLL(root.left);
		
		if(prev==null) head=root;
		else {
			prev.right=root;
			root.left=prev;
		}
		prev=root;
		
		BSTToDLL(root.right);
	}
	
	 void printList(Node node) { 
		 while (node != null) { 
			 System.out.print(node.val + " "); 
	         node = node.right; 
	     } 
	 } 
	
	public static void main(String[] args) {
		Node bst = new Node(10);
		
		bst.left = new Node(7);
		bst.left.left = new Node(5);
		bst.left.right = new Node(8);
		bst.left.left.left = new Node(4);
		bst.left.left.right = new Node(6);
		
		bst.right = new Node(17);
		bst.right.left = new Node(12);
		bst.right.right = new Node(20);
		bst.right.right.left = new Node(18);
		
		BSTToDLL sol = new BSTToDLL();
		sol.BSTToDLL(bst);
		
		sol.printList(sol.head);

	}

}
