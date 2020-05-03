package com.rizstien.algos;

import java.util.ArrayList;
import java.util.Collections;

public class BalancedSplit {
	  static boolean balancedSplitExists(int[] arr) {
		    ArrayList<Integer> A = new ArrayList<Integer>();
		    for(int a : arr) A.add(a);
		    Collections.sort(A);

		    int i=1,j=A.size()-1;
		    int sumA=A.get(0)+A.get(i);
		    int sumB=0;
		    if(A.get(j)>A.get(i)) sumB=A.get(j);
		    else return false;
		    while(i<j){
		      if(sumA==sumB) {
		    	  if(i+1==j) return true;
		    	  return false;
		      }else if(sumA<sumB){
		        i++;
		        sumA=sumA+A.get(i);
		      }else if(sumB<sumA){
		        j--;
		        sumB = sumB+A.get(j);
		      }
		    }
		    return false;
		    
		  }
	public static void main(String[] args) {
		System.out.println(balancedSplitExists(new int[] {3,6,3,4,4}));

	}

}
