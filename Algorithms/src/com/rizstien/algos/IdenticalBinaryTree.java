package com.rizstien.algos;

import java.util.Stack;

public class IdenticalBinaryTree {
	 class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	 }
	 
	 public int isSameTree(TreeNode A, TreeNode B) {
        Stack<TreeNode> stackA = new Stack<TreeNode>();
        Stack<TreeNode> stackB = new Stack<TreeNode>();
	        
        while((A!=null || !stackA.isEmpty()) && (B!=null || !stackB.isEmpty())){
            while(A!=null){
                stackA.push(A);
                A=A.left;
            }
            
            while(B!=null){
                stackB.push(B);
                B=B.left;
            }
            
            if(A==null && !stackA.isEmpty() && B==null && !stackB.isEmpty()){
                A = stackA.pop();
                B = stackB.pop();
                if(A.val!=B.val) return 0;
                A = A.right;
                B = B.right;
            }
        }
	        
        if(stackA.size()!=stackB.size()) return 0;
        return 1;
	 }
}
