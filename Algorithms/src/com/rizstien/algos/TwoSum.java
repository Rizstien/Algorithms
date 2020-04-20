package com.rizstien.algos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TwoSum {
    public ArrayList<Integer> twoSum(final List<Integer> A, int B) {
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
}
