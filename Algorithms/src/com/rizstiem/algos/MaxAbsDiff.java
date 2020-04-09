package com.rizstiem.algos;

import java.util.ArrayList;

public class MaxAbsDiff {
	public int maxArr(ArrayList<Integer> A) {        
        int maxSum=A.get(0);
        int minSum=A.get(0);
        
        for(int i=0;i<A.size();i++){
            maxSum = Math.max(maxSum,A.get(i)+i);
            minSum = Math.min(minSum,A.get(i)+i);
        }
        
        int sumRes = maxSum-minSum;
        
        int maxDiff=A.get(0);
        int minDiff=A.get(0);
        
        for(int i=0;i<A.size();i++){
            maxDiff = Math.max(maxDiff,A.get(i)-i);
            minDiff = Math.min(minDiff,A.get(i)-i);
        }
        
        int diffRes = maxDiff-minDiff;
        
        return Math.max(sumRes,diffRes);
    }

}
