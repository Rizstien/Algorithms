package com.rizstien.algos;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MinimizingPermutations {
	static class Node { 
		String string ; 
		int steps;         
		Node(String string,int steps) { 
			this.string = string; 
			this.steps= steps; 
		} 
	} 

	static String reverse (String s , int index) { 
		char temp []= s.toCharArray();
		int i = 0; 
		while (i < index) 
		{ 
			char c = temp[i]; 
			temp[i] = temp[index-1]; 
			temp[index-1] = c; 
			i++;index--; 
		} 
		return String.valueOf(temp); 
	} 

	static int minOperations(int[] arr) {
		int n = arr.length;  
		String start = "", destination = "";  
		String original = "",modified = "";  
		Node temp = null; 

		for (int i = 0; i < n; i++) start += arr[i]; 

		Arrays.sort(arr); 
		for (int i = 0; i < n; i++) destination += arr[i]; 

		Queue<Node> q = new LinkedList<>(); 
		q.add(new Node(start, 0)); 
		if (start == destination) return 0; 
		
		while (!q.isEmpty()) {  
			temp = q.poll(); 
			original = temp.string; 
			for (int j = 2; j <= n; j++) {  
				modified = original;  
				modified = reverse (modified , j); 

				if (modified.equals(destination)) return temp.steps + 1;
				q.add(new Node(modified,temp.steps + 1)); 
			} 

		}
		return -1;
	}
	
	public static void main(String[] args) {
		System.out.println(minOperations(new int[] {1, 2, 5, 4, 3}));
	}

}
