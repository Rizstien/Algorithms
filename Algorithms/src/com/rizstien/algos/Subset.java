package com.rizstien.algos;

import java.util.ArrayList;
import java.util.Collections;

public class Subset {
	public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        if (A == null)
		    return null;
 
	    Collections.sort(A);
 	    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	    ArrayList<ArrayList<Integer>> prev = new ArrayList<ArrayList<Integer>>();
 
	    for (int i = A.size()-1; i >= 0; i--) {
    		//get existing sets
    		if (i == A.size() - 1 || A.get(i) != A.get(i + 1) || prev.size() == 0) {
    			prev = new ArrayList<ArrayList<Integer>>();
    			for (int j = 0; j < result.size(); j++) {
    				prev.add(new ArrayList<Integer>(result.get(j)));
    			}
    		}
 
    		//add current number to each element of the set
    		for (ArrayList<Integer> temp : prev) {
    			temp.add(0, A.get(i));
    		}
 
    		//add each single number as a set, only if current element is different with previous
    		if (i == A.size() - 1 || A.get(i) != A.get(i + 1)) {
    			ArrayList<Integer> temp = new ArrayList<Integer>();
    			temp.add(A.get(i));
    			prev.add(temp);
    		}
 
    		//add all set created in this iteration
    		for (ArrayList<Integer> temp : prev) {
    			result.add(new ArrayList<Integer>(temp));
    		}
	    }
 
    	//add empty set
    	result.add(new ArrayList<Integer>());
        Collections.reverse(result);
	    return result;
	}
}
