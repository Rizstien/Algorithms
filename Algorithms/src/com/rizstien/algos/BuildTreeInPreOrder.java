package com.rizstien.algos;

import java.util.List;

public class BuildTreeInPreOrder {
	 class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	 }
	 
	    public TreeNode buildTree(List<Integer> pre, List<Integer> in) {
	        if(in==null || in.size()==0) return null;
	        TreeNode root = new TreeNode(pre.get(0));
	        if(in.size()==1) return root;
	        
	        int indexRoot = in.indexOf(root.val);
	        
	        List<Integer> inL = in.subList(0,indexRoot);
	        List<Integer> inR = in.subList(indexRoot+1,in.size());
	        
	        List<Integer> preL = pre.subList(1,indexRoot+1);
	        List<Integer> preR = pre.subList(indexRoot+1,in.size());
	        
	        root.left = buildTree(preL,inL);
	        root.right = buildTree(preR,inR);
	        
	        return root;
	    }
}
