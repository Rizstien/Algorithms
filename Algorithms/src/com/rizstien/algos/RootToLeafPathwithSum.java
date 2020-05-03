package com.rizstien.algos;

import java.util.ArrayList;

public class RootToLeafPathwithSum {
	 class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	 }
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int k) {
        if (root == null) {return new ArrayList<>();}
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        pathSum(root, k, root.val, res, new ArrayList<>());
        return res;
    }

    private void pathSum(TreeNode root, int k, int sum, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> list) {
        list.add(root.val);
        if (root.left == null && root.right == null && sum == k) {res.add(new ArrayList<>(list));}
        if (root.left != null) {pathSum(root.left, k, root.left.val + sum, res, new ArrayList<>(list));}
        if (root.right != null) {pathSum(root.right, k, root.right.val + sum, res, new ArrayList<>(list));}
    }
}
