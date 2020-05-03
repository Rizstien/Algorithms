package com.rizstien.algos;

import java.util.Arrays;

public class MaxContiguousSubarrays {
	static int findMaxContigiousRight(int[] arr, int index){
	    int count=0;
	    for(int i=index+1;i<arr.length;i++){
	      if(arr[index]>=arr[i]) count++;
	      else break;
	    }
	    return count;
	}
	  
	static int findMaxContigiousLeft(int[] arr, int index){
	    int count=0;
	    for(int i=index-1;i>=0;i--){
	      if(arr[index]>=arr[i]) count++;
	      else break;
	    }
	    return count;
	}

	static int[] countSubarrays(int[] arr) {
	    int[] result = new int[arr.length];
	    Arrays.fill(result,1);
	    
	    for(int i=0;i<arr.length;i++){
	      int left = findMaxContigiousLeft(arr,i);
	      int right = findMaxContigiousRight(arr,i);
	      result[i] = result[i]+left+right;
	    }
	    return result;
	}
	
	public static void main(String[] args) {
		countSubarrays(new int[] {3, 4, 1, 6, 2});
		countSubarrays(new int[] {2, 4, 7, 1, 5, 3});
	}

}
