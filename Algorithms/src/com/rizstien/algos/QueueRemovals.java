package com.rizstien.algos;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueRemovals {
	static class Pair implements Comparable<Pair>{
	    int index;
	    int val;
	    Pair(int index, int val){
	      this.index=index;
	      this.val=val;
	    }
	    
	    public int compareTo(Pair pair){
	      return pair.val-this.val;
	    }
	  }
	  

	  static int[] findPositions(int[] arr, int x) {
	    //Prepare queue
	    int[] result = new int[x];
	    Queue<Pair> queue = new LinkedList<Pair>();
	    for(int i=0;i<arr.length;i++){
	      queue.add(new Pair(i+1,arr[i]));
	    }
	    
	    for(int i=0;i<x;i++){
	      int j=0;
	      PriorityQueue<Pair> local = new PriorityQueue<Pair>();
	      while(!queue.isEmpty() && j<x){
	        local.add(queue.remove());
	        j++;
	      }
	      Pair max = local.remove();
	      result[i] = max.index;
	      while(!local.isEmpty()){
	        Pair pair = local.remove();
	        if(pair.val>0) pair.val--;
	        queue.add(pair);
	      }
	    }
	    return result;
	  }
	  
	public static void main(String[] args) {
		findPositions(new int[]{1, 2, 2, 3, 4, 5},5);  //{5, 6, 4, 1, 2 }
		findPositions(new int[]{2, 4, 2, 4, 3, 1, 2, 2, 3, 4, 3, 4, 4},4);  //{2, 5, 10, 13}

	}

}
