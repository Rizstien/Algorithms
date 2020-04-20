package com.rizstien.algos;

import java.util.ArrayList;
import java.util.Collections;

public class Permutations {
	static ArrayList<ArrayList<Integer>> permList = new ArrayList<ArrayList<Integer>>();
    public static ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        permute(A,0,A.size()-1);
        return permList;
    }
    
    public static void permute(ArrayList<Integer> A,int start, int end){
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
    
	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<Integer>();
		A.add(1);
		A.add(2);
		A.add(3);
		ArrayList<ArrayList<Integer>> result = permute(A);
		result.forEach(list->list.forEach(e->System.out.print(e+", ")));
	}

}
