package com.rizstiem.algos;

import java.util.Arrays;

public class LIS {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    
    public int lis(final int[] A) {
        if(A == null || A.length==0) return 0;
        if(A.length==1) return 1;
        
        int[] max = new int[A.length];
        Arrays.fill(max,1);

        int incOrderGlobal=1;
        for(int j=1;j<A.length;j++){
            for(int i=0;i<j;i++){
                if(A[i]<A[j]){
                    max[j]=Math.max(max[j],max[i]+1);
                }
            }
            incOrderGlobal = Integer.max(incOrderGlobal, max[j]);
        }
        return incOrderGlobal;   
    }
}

