package com.rizstien.algos;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class MatrixMedian {
	class ArrayContainer implements Comparable<ArrayContainer>{
        ArrayList<Integer> arr;
        int index;
        ArrayContainer(ArrayList<Integer> arr, int index){
            this.arr=arr;
            this.index=index;
        }
        public int compareTo(ArrayContainer ac){
            return this.arr.get(this.index).compareTo(ac.arr.get(ac.index));
        }
    }
	
	public int findMedian(ArrayList<ArrayList<Integer>> A) {
        PriorityQueue<ArrayContainer> pq = new PriorityQueue<ArrayContainer>();
        ArrayContainer ac;
        ArrayList<Integer> arr;
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i=0;i<A.size();i++){
            arr = new ArrayList<Integer>();
            for(int j=0;j<A.get(i).size();j++){
                arr.add(A.get(i).get(j));
            }
            ac = new ArrayContainer(arr,0);
            pq.add(ac);
        }
        
        while(!pq.isEmpty()){
            ac = pq.remove();
            list.add(ac.arr.get(ac.index));
            if(ac.index+1<ac.arr.size())
                pq.add(new ArrayContainer(ac.arr,ac.index+1));
        }
        int low = 0, high = list.size()-1;
        return list.get(low+(high-low)/2);
    }
}
