package com.rizstien.algos;

import java.util.Comparator;
import java.util.PriorityQueue;

public class FindMaxProd {
	static int[] findMaxProduct(int[] arr) {
	    int[] result = new int[arr.length];
	    result[0]=-1;
	    result[1]=-1;
	    PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>(){
	      public int compare(Integer val1, Integer val2){
	        return val2-val1;
	      }
	    });
	    
	    for(int i=0;i<=2;i++) pq.add(arr[i]);
	    int prod=0;
	    for(int i=3;i<=arr.length;i++){
	      prod=0;
	      int first = pq.remove();
	      int second = pq.remove();
	      int third = pq.remove();
	      prod = first*second*third;
	      result[i-1] = prod;
	      pq.add(first);
	      pq.add(second);
	      pq.add(third);
	      if(i<arr.length) pq.add(arr[i]);
	    }
	    return result;
	  }
	public static void main(String[] args) {
		findMaxProduct(new int[]{2, 4, 7, 1, 5, 3});
	}

}
