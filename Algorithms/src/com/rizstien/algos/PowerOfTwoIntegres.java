package com.rizstien.algos;

public class PowerOfTwoIntegres {
    public int isPower(int A) {
        if(A==1) return 1;
        int n=0;
        for(int i=2;i<=Math.sqrt(A);i++){
            if(A%i==0) {
            	n=A;
                while(n%i==0){
                    n=n/i;
                }
                if(n==1) return 1;
            }
        }
        return 0;
    }
}
