package com.rizstien.algos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindNodesInSubtree {
	class Node {
	    public int val;
	    public List<Node> children;
	  
	    public Node(int _val) {
	      val = _val;
	      children = new ArrayList<Node>();
	    }
	 }

	  class Query {
	    int v; 
	    char c; 
	    Query(int v, char c) {
	      this.v = v; 
	      this.c = c;
	    }
	  }

	  Node find(Node root, int val, Set<Integer> visited){
	    if(visited.contains(root.val)) return null;
	    visited.add(root.val);
	    if(root.val==val) {
	      return root;
	    }
	    
	    for(Node child : root.children){
	      Node node = find(child,val,visited);
	      if(node!=null){
	        return node;
	      }
	    }
	    return null;
	  }
	  
	  int dfsAllNodes(Node root,char val,Set<Integer> visited,String s,int count){
	    if(visited.contains(root.val)) return count;
	    if(s.charAt((root.val)-1)==val) count++;
	    visited.add(root.val);
	    for(Node child : root.children){
	      count = dfsAllNodes(child,val,visited,s,count);
	    }
	    return count;
	  }

	  int[] countOfNodes(Node root, ArrayList<Query> queries, String s) {
	    int[] result = new int[queries.size()];
	    for(int i=0;i<queries.size();i++){
	      Set<Integer> visited = new HashSet<Integer>();
	      int count=0;
	      Node node = find(root,queries.get(i).v,visited);
	      visited = new HashSet<Integer>();
	      result[i] = dfsAllNodes(node,queries.get(i).c,visited,s,count);
	    }
	    return result;
	  }
}
