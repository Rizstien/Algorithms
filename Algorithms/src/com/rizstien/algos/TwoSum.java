package com.rizstien.algos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class TwoSum {
    public static ArrayList<Integer> twoSum(final List<Integer> A, int B) {
        HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        for(int i=0;i<A.size();i++){
            if(map.containsKey(B-A.get(i))){
                result.add(map.get(B-A.get(i)));
                result.add(i+1);
                return result;
            }else if(!map.containsKey(A.get(i))){
                map.put(A.get(i),i+1);
            }
            
        }
        return result;
    }
    
    public static void main(String args[]) {
    	List<Integer> A = new ArrayList<Integer>(Arrays.asList(1,2,3,7,11,15,2,7));
    	twoSum(A,5).forEach(e->System.out.println(e));
    }
}
