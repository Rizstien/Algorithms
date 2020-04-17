package com.rizstien.algos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SingleNumber {
	    // DO NOT MODIFY THE LIST. IT IS READ ONLY
	    public static int singleNumber(final List<Integer> A) {
	        Collections.sort(A);
	        int strike=0;
	        for(int i=0;i<A.size()-1;i++){
	            if((A.get(i)^A.get(i+1))==0){
	              strike=0;  
	            } 
	            else strike++;
	            if(strike==2) {
	            	return A.get(i);
	            }else if(strike==1 && i==A.size()-2) {
	            	return A.get(i+1);
	            }
	        }
	        return A.get(0);
	    }

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(2);
		list.add(3);
		list.add(1);
		list.add(4);
		list.add(4);
		System.out.println(2 | ~(2 - (1<<3)));

	}

}
