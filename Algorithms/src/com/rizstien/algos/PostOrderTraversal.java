package com.rizstien.algos;

import java.util.ArrayList;
import java.util.Stack;

public class PostOrderTraversal {
	 class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	 }
	 
	public ArrayList<Integer> postorderTraversal(TreeNode A) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if(A!=null) stack.push(A);
        TreeNode node=null;
        while(!stack.isEmpty()){
            node = stack.pop();
            if(node.left==null && node.right==null) result.add(node.val);
            else{
                stack.push(node);
                
                if(node.right!=null){
                    stack.push(node.right);
                    node.right=null;
                }
                
                if(node.left!=null){
                    stack.push(node.left);
                    node.left=null;
                }
            }
        }
        return result;
    }
}
