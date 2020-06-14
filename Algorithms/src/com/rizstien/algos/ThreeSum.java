package com.rizstien.algos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] arr) {
    	List<List<Integer>> result = new ArrayList<>();
		//Sort an array
		Arrays.sort(arr);
		//Run a loop from 0 to n
		for (int i = 0; i < arr.length; i++) {
			//Declare and intialize two indexes
			int start = i + 1;
			int end = arr.length - 1;
			if (i > 0 && arr[i] == arr[i - 1]) {
				continue;
			}
			while (start < end) {
				//Ignore duplicates
				if (end < arr.length - 1 
						&& arr[end] == arr[end + 1]) {
					end--;
					continue;
				}
				//If triplets is found then put them in a list
				if (arr[i] + arr[start] + arr[end] == 0) {
					List<Integer> val = 
							Arrays.asList(arr[i],arr[start],arr[end]);
					result.add(val);
					start++; end--;
				} else if (arr[i] + arr[start] + arr[end] < 0) {
					start++;
				} else {
					end--;
				}
			}
		}
		return result;
    }
    
    public static void main(String args[]) {
    	int[] A = new int[]{-1,0,1,2,-1,-4};
    	threeSum(A).forEach(e->System.out.println(e));
    }
}
