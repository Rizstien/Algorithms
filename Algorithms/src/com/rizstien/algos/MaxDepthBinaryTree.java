package com.rizstien.algos;

public class MaxDepthBinaryTree {
	 class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	 }
    public int maxDepth(TreeNode A) {
        if(A==null) return 0;
        if(A.left==null && A.right==null) return 1;
        else{
            return Math.min(maxDepth(A.left),maxDepth(A.right))+1;
        }
    }
}
