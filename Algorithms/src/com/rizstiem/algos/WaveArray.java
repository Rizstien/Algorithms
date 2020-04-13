package com.rizstiem.algos;

import java.util.ArrayList;
import java.util.Collections;

public class WaveArray {
	public static ArrayList<Integer> wave(ArrayList<Integer> A) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		Collections.sort(A);
		while(A.size()>0) {
			Integer large = find1stLarge(A);
			result.add(large);
			if(A.size()>0){
			    Integer small = find1stSmall(A);
			    result.add(small);
			}
		}
		
		return result;
	}
	
	static Integer find1stLarge(ArrayList<Integer> A){
		Integer val = A.get(0);
		for(int i=0;i<A.size()-1;i++) {
			if(A.get(i)<=A.get(i+1)) {
				val = A.get(i+1);
				A.remove(i+1);
				return val;
			}
		}
		A.remove(0);
		return val;
	}
	
	static Integer find1stSmall(ArrayList<Integer> A){
		Integer val = A.get(0);
		for(int i=0;i<A.size()-1;i++) {
			if(A.get(i)<=A.get(i+1)) {
				val = A.get(i);
				A.remove(i);
				return val;
			}
		}
		
		A.remove(0);
		return val;
    }
	
	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<Integer>();
		A.add(1);
		A.add(2);
		A.add(3);
		A.add(4);
		A.add(5);
		A = wave(A);
		A.forEach(a->System.out.print(a+", "));
	}

}
