package com.rizstien.algos;

public class MinDepthBinaryTree {
	 class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	 }
    public int minDepth(TreeNode A) {
        if(A==null) return Integer.MAX_VALUE;
        if(A.left==null && A.right==null) return 1;
        else{
            return Math.min(minDepth(A.left),minDepth(A.right))+1;
        }
    }
}
