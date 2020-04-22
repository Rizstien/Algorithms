package com.rizstien.algos;

import java.util.Stack;

public class KthSmallestElement {
	 class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	 }
	 
    public int kthsmallest(TreeNode A, int B) {
    	int count=0;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        while(A!=null || !stack.isEmpty()){
            while(A!=null){
                stack.push(A);
                A=A.left;
            }
            
            if(A==null && !stack.isEmpty()){
                A = stack.pop();
                count++;
                if(count==B){ return A.val;}
                A = A.right;
            }
        }
        return -1;
    }
}
