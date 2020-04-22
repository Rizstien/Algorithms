package com.rizstien.algos;

import java.util.Stack;

public class BSTIterator {
	 class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	 }
	 Stack<TreeNode> stack = new Stack<TreeNode>();
	    
	    public BSTIterator(TreeNode root) {
	        while(root!=null){
	            stack.push(root);
	            root = root.left;
	        }    
	    }

	    /** @return whether we have a next smallest number */
	    public boolean hasNext() {
	        return !stack.isEmpty();
	    }

	    /** @return the next smallest number */
	    public int next() {
	        TreeNode minNode = stack.pop();
	        addRightLeft(minNode.right);
	        return minNode.val;
	    }
	    
	    public void addRightLeft(TreeNode node){
	        while(node!=null){
	            stack.push(node);
	            node = node.left;
	        }  
	    }
}
