package com.rizstien.algos;

import java.util.ArrayList;
import java.util.Stack;

public class InOrderTraversal {
	 class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	 }
	 
    public ArrayList<Integer> inorderTraversal(TreeNode A) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        while(A!=null || !stack.isEmpty()){
            while(A!=null){
                stack.push(A);
                A=A.left;
            }
            
            if(A==null && !stack.isEmpty()){
                A = stack.pop();
                result.add(A.val);
                A = A.right;
            }
        }
        return result;
    }
}
