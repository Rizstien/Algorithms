package com.rizstiem.algos;

import java.util.ArrayList;
import java.util.LinkedList;

public class FindPermutation {

    public static ArrayList<Integer> findPerm(final String A, int B) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        LinkedList<Integer> list = new LinkedList<Integer>();
        for(int i=1;i<=B;i++){
            list.add(i);
        }
        
        for(char ins : A.toCharArray()){
            if(ins=='I'){
               result.add(list.get(0));
               list.remove(0);
            }else{
                result.add(list.get(list.size()-1));
               list.remove(list.size()-1);
            }
        }
        result.add(list.get(list.size()-1));
        return result;
    }
	
	public static void main(String[] args) {
		ArrayList<Integer> result;
		result = findPerm("IDDI", 5);
		result.forEach(e->System.out.print(e+", "));
	}

}
