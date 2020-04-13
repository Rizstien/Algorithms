package com.rizstien.algos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RepeatedNumber {
    public static int repeatedNumber(final List<Integer> A) {
        Collections.sort(A);
        for(int i=0;i<A.size()-1;i++){
            if(A.get(i).equals(A.get(i+1))){
                return A.get(i);
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
    	ArrayList<Integer> A = new ArrayList<Integer>();
    	A.add(3);
    	A.add(1);
    	A.add(4);
    	A.add(1);
    	A.add(4);
    	System.out.println(repeatedNumber(A));
    }
}
