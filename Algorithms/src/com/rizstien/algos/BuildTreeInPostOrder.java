package com.rizstien.algos;

import java.util.List;

public class BuildTreeInPostOrder {
	 class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	 }
	 
    public TreeNode buildTree(List<Integer> in, List<Integer> post) {
        if(in==null || in.size()==0) return null;
        TreeNode root = new TreeNode(post.get(post.size()-1));
        if(in.size()==1) return root;
        int rootIndex = in.indexOf(root.val);
        
        List<Integer> inL =  in.subList(0,rootIndex);
        List<Integer> inR =  in.subList(rootIndex+1,in.size());
        
        List<Integer> postL =  post.subList(0,rootIndex);
        List<Integer> postR =  post.subList(rootIndex,post.size()-1);
        
        root.left = buildTree(inL,postL);
        root.right = buildTree(inR,postR);
        
        return root;
    }
}
