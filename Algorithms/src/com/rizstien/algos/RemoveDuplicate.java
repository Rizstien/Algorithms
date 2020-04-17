package com.rizstien.algos;

import java.util.ArrayList;
import java.util.Collections;

public class RemoveDuplicate {
    public static int removeDuplicates(ArrayList<Integer> a) {
        Collections.sort(a);
        for(int i=0;i<a.size()-1;){
            if(a.get(i)==a.get(i+1)){ 
                System.out.println(a.get(i));
                a.remove(i);
            }
            else i++;
        }
        return a.size();
    }
	
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(5000);
		list.add(5000);
		list.add(5000);
		removeDuplicates(list);

	}

}
