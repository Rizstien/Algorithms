package com.rizstien.algos;

import java.util.ArrayList;
import java.util.Collections;

public class RemoveDuplicatesFromSortedArray {
	public static int removeDuplicates(ArrayList<Integer> A) {
        int index=0;
        for(int i=1;i<A.size();i++){
            if(!A.get(i).equals(A.get(index))){
                Collections.swap(A,i,index+1);
                index++;
            }
        }
        return index+1;
    }
	
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(1);
		list.add(2);
		list.add(2);
		list.add(3);
		list.add(3);
		System.out.println(removeDuplicates(list));
	}
}
