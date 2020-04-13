package com.rizstien.algos;

import java.util.List;

public class MaxSumContiguouSubArray {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int maxSubArray(final List<Integer> A) {
        if(A == null || A.isEmpty()) return 0;
        
        int maxSum =  A.get(0);
        int runningSum = A.get(0);
        int len = A.size();
        int current;
        for(int i = 1; i < len; i++){
            current = A.get(i);
            runningSum = Math.max(runningSum + current,current);
            maxSum = Math.max(runningSum, maxSum);
        }
        return maxSum;
    }
}
