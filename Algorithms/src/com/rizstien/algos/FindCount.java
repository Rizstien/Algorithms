package com.rizstien.algos;

import java.util.List;

public class FindCount {
	public int findCount(final List<Integer> A, int B) {
        int firstIndex = findCount(A,B,true);
        if(firstIndex==-1){
            return 0;
        }else{
            int lastIndex = findCount(A,B,false);
            return lastIndex-firstIndex+1;
        }
    }
    
    public int findCount(final List<Integer> A, int B, boolean flag) {
        int start=0, end = A.size()-1, result = -1;
        while(start<=end){
            int mid = start+(end-start)/2;
            if(A.get(mid)==B){
                result=mid;
                if(flag)
                    end=mid-1;
                else
                    start=mid+1;
            }else if(A.get(mid)>B){
                end = mid-1; 
            }else{
                start = mid+1;
            }
        }
        return result;
    }
}
