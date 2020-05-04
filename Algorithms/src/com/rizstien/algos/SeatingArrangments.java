package com.rizstien.algos;

import java.util.ArrayList;
import java.util.Collections;

public class SeatingArrangments {
	static ArrayList<ArrayList<Integer>> permList = new ArrayList<ArrayList<Integer>>();
	static ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
		permute(A,0,A.size()-1);
		return permList;
	}

	static void permute(ArrayList<Integer> A,int start, int end){
		if(start==end){
			permList.add(new ArrayList<Integer>(A));
		}else{
			for(int i=start;i<=end;i++){
				Collections.swap(A,start,i);
				permute(A,start+1,end);
				Collections.swap(A,start,i);
			}
		}
	}

	static int minOverallAwkwardness(int[] arr) {
		ArrayList<Integer> A = new ArrayList<Integer>();
		for(int a : arr) A.add(a);
		permute(A);
		int min=Integer.MAX_VALUE;
		for(ArrayList<Integer> perm : permList){
			int max=0;
			int i=0;
			for(;i<perm.size()-1;i++){
				max=Math.max(Math.abs(perm.get(i)-perm.get(i+1)),max);
			}
			max=Math.max(Math.abs(perm.get(i)-perm.get(0)),max);
			min=Math.min(max,min);
		}
		return min;
	}
	
	public static void main(String[] args) {
		System.out.println(minOverallAwkwardness(new int[] {5, 10, 6, 8}));
		System.out.println(minOverallAwkwardness(new int[] {1, 2, 5, 3, 7}));
	}

}
