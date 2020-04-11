package com.rizstiem.algos;

import java.util.ArrayList;
import java.util.Collections;

public class NobelInteger {
    public static int solve(ArrayList<Integer> A) {
        Collections.sort(A);
        
        for(int j=0;j<A.size()-1;j++){
            if(A.get(j)<0 || A.get(j)==A.get(j+1)) continue;
            if(A.get(j)==A.size()-1-j) return 1;
        }
        if(A.get(A.size()-1)==0) return 1;
        return -1;
    }
    
	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<Integer>();
		A.add(1);
		A.add(2);
		A.add(4);
		A.add(4);
		System.out.println(solve(A));
	}

}
