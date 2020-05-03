package com.rizstien.algos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class PassingYearBookSignature {
	static ArrayList<Integer> calculateNextPermutaion(int[] arr){
	    ArrayList<Integer> A = new ArrayList<Integer>();
	    for(int a : arr) A.add(a);
	    int lastMinIndex = findLastMin(A);
	    if(lastMinIndex==-1) { 
	      Collections.reverse(A);
	      return A;
	    }
	    
	    int lastMaxIndex = findLastMax(A,lastMinIndex);
	    Collections.swap(A,lastMinIndex,lastMaxIndex);
	    Collections.reverse(A.subList(lastMinIndex+1,A.size()));
	    return A;
	}
	  
	static int findLastMin(ArrayList<Integer> A){
	    int j=-1;
	    for(int i=0;i<A.size()-1;i++){
	      if(A.get(i)<A.get(i+1)) j=i;
	    }
	    return j;
	}
	   
	static int findLastMax(ArrayList<Integer> A, int index){
	    int j=-1;
	    for(int i=index+1;i<A.size()-1;i++){
	      if(A.get(i)>A.get(i+1)) j=i;
	    }
	    return j;
	}
	  
	static boolean checkYearbookIsBack(int[] arr){
	    int i=0;
	    for(;i<arr.length;i++){
	      if(i+1!=arr[i]) break;
	    }
	    
	    if(i==arr.length) return true;
	    return false;
	}
	  
	static void incrementSignatureCount(ArrayList<Integer> nextPerm, int[] arr,int[] result){
	    for(int i=0;i<arr.length;i++){
	      if(!nextPerm.get(i).equals(arr[i])) result[i]++;
	    }
	}

	static int[] findSignatureCounts(int[] arr) {
	    int[] result = new int[arr.length];
	    Arrays.fill(result,1);
	    if(checkYearbookIsBack(arr)) return result;
	    else{
	      ArrayList<Integer> nextPerm = calculateNextPermutaion(arr);
	      incrementSignatureCount(nextPerm, arr, result);
	      if(checkYearbookIsBack(arr)) return result;
	    }
	    return result;
	  }
	public static void main(String[] args) {
		System.out.println(findSignatureCounts(new int[] {3,2,1}));
		System.out.println(findSignatureCounts(new int[] {2,1}));
		System.out.println(findSignatureCounts(new int[] {1,2}));

	}

}
