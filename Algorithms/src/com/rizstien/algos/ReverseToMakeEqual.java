package com.rizstien.algos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class ReverseToMakeEqual {

	static boolean areTheyEqual(int[] array_a, int[] array_b) {
	    List<Integer> A = new ArrayList<Integer>(array_a.length);
	    for (int a : array_a) A.add(a);  //O(n)
	    
	    List<Integer> B = new ArrayList<Integer>(array_b.length);
	    for (int b : array_b) B.add(b); //O(n)
	    
	    Stack<Integer> stack = new Stack<Integer>();
	    int start=-1,end=-1;
	    for(int i=0;i<A.size();i++){
	      if(A.get(i)!=B.get(i)) stack.push(i); //O(n)
	    }
	    
	    end = stack.pop();
	    while(stack.size()>1) stack.pop(); //O(n)
	    if(stack.size()==1) start = stack.pop();
	    
	    if(end!=-1 && start!=-1){
	      Collections.reverse(A.subList(start,end+1)); //O(n)
	      if(A.equals(B)) return true;
	    }
	    return false;
	}
	
	
	public static void main(String[] args) {
		System.out.println(areTheyEqual(new int[] {1,2,3,4}, new int[] {1,4,3,2}));

	}

}
