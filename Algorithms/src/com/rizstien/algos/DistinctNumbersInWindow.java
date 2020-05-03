package com.rizstien.algos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class DistinctNumbersInWindow {
	public ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(A.size()<B) return result;
        LinkedList<Integer> window = new LinkedList<Integer>();
        Map<Integer,Integer> distinct = new HashMap<Integer,Integer>();
        int start=0;
        for(int i=0;i<A.size();i++){
            window.add(A.get(i));
            addToMap(distinct,A.get(i));
            if(i>=B-1+start){
                result.add(distinct.size());
                removeFromMap(distinct,window.remove(0));
                start++;
            }
        }
        return result;
    }
    
    void addToMap(Map<Integer,Integer> map, int val){
        if(map.containsKey(val)){
            map.put(val,map.get(val)+1);
        }else{
            map.put(val,1);
        }
    }
    
    void removeFromMap(Map<Integer,Integer> map, int val){
        if(map.get(val)==1){
            map.remove(val);
        }else{
            map.put(val,map.get(val)-1);
        }
    }
}
