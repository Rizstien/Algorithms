package com.rizstiem.algos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LargestNumber {
	public String largestNumber(final List<Integer> A) {
        StringBuilder strBldr = new StringBuilder();
        ArrayList<String> arr = new ArrayList<String>();
        for(int i=0;i<A.size();i++){
            arr.add(Integer.toString(A.get(i)));
        }
        
        Collections.sort(arr,(x,y) ->{
                String XY = x+y;
                String YX = y+x;
                return YX.compareTo(XY);
        });
        
        for(int i=0;i<arr.size();i++){
            strBldr.append(arr.get(i));
        }
        
        int i=0;
        while(i<strBldr.length()-1){
            if(strBldr.charAt(i)=='0'){
                i++;
            }else{
                break;
            }
        }
        if(i>0){
            strBldr.delete(0,i);
        }
        
        if(strBldr.length()==0) strBldr.append("0");
        
        return strBldr.toString();
    }
}
