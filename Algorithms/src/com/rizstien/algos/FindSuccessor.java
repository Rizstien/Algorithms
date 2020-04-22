package com.rizstien.algos;

public class FindSuccessor {
	 class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
	}
	 
    public TreeNode getSuccessor(TreeNode a, int b) {
        if(a==null) return null;
        //if(curr!=null) return curr;
        TreeNode itr = a;
        TreeNode successor = null;
        while(itr!=null){
            if(itr.val==b) break;
            else if(itr.val>b) {successor = itr; itr = itr.left;}
            else if(itr.val<b) itr = itr.right;
        }
        
        if(itr.right!=null){
            itr=itr.right;
            while(itr.left!=null){
                itr=itr.left;
            }
            return itr;
        }
        return successor;
    }
}
