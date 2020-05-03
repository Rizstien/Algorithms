package com.rizstien.algos;

public class NodesVisibleFromLeft {
	class Node {
	    int data; 
	    Node left; 
	    Node right; 
	    Node() {
	      this.data = 0; 
	      this.left = null; 
	      this.right = null; 
	    }
	    Node(int data) {
	      this.data = data; 
	      this.left = null; 
	      this.right = null; 
	    }
	  }
	  int maxLevel=0;
	  void visibleNodesUtil(Node node, int level){
	    if(node==null) return;
	    if(level>maxLevel){
	      System.out.println(node.data);
	      maxLevel=level;
	    }
	    
	    visibleNodesUtil(node.left,level+1);
	    visibleNodesUtil(node.right,level+1);
	  }
	  

	  int visibleNodes(Node root) {
	    visibleNodesUtil(root,1);
	    return 1;
	  }
}
