package com.rizstien.algos;

import java.util.HashMap;
import java.util.Map;

public class PairSum {

	static int numberOfPairs(int[] arr, int k) {
		int count=0;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i=0;i<arr.length;i++) {
			if(map.containsKey(arr[i])) {
				map.put(arr[i], map.get(arr[i])+1);
			}else {
				map.put(arr[i],1);
			}
		}
		
		for(int i=0;i<arr.length;i++) {
			if(map.containsKey(k-arr[i])) {
				count=count+map.get(k-arr[i]);
			}
			
			if(k-arr[i]==arr[i]) count--;
		}
		
		
		return count/2;
	}
	
	public static void main(String[] args) {
		System.out.println(numberOfPairs(new int[] {1,5,3,3,3}, 6));

	}

}
