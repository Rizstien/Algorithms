package com.rizstien.algos;

public class IsValidBST {
	 class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	 }
	 
	public int isValidBST(TreeNode a) {
	    return isValidBSTUtil(a, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	private int isValidBSTUtil(TreeNode a, int min, int max){
	    if(a == null){
	        return 1;
	    }
	    if(a.val > min && a.val < max){
	        return isValidBSTUtil(a.left, min, a.val) & isValidBSTUtil(a.right, a.val, max);
	    }else{
	        return 0;
	    }
	}
}
