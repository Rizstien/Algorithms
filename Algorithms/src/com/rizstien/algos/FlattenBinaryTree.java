package com.rizstien.algos;

import java.util.Stack;

public class FlattenBinaryTree {
	 class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	 }
	 
	public TreeNode flatten(TreeNode a) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode result = null;
        TreeNode pointer = null;
        if(a==null) return null;
        
        if((a.left==null || a.left.val==-1) 
            && (a.right==null || a.right.val==-1)) return a;
        
        stack.push(a);
        result = a;
        pointer = result;
        TreeNode node = null;
        while(!stack.isEmpty()){
            node = stack.pop();
            if((node.left==null || node.left.val==-1) && (node.right==null || node.right.val==-1)) {
                pointer.right = node;
                pointer.left = null;
                pointer = pointer.right;
            }else{
                if(node.right!=null && node.right.val!=-1){
                    stack.push(node.right);
                    node.right=null;
                }
                if(node.left!=null && node.left.val!=-1){
                    stack.push(node.left);
                    node.left=null;
                }
                stack.push(node);
            }
        }
        return result;
    }
}
