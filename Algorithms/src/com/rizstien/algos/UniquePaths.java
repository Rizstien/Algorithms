package com.rizstien.algos;

public class UniquePaths {
    public int uniquePaths(int A, int B) {
        int[][] AB = new int[A][B];
        
        for(int i=0;i<A;i++){
            AB[i][0]=1;   
        }
        
        for(int i=0;i<B;i++){
            AB[0][i]=1;   
        }
        
        for(int i=1;i<A;i++){
            for(int j=1;j<B;j++){
                AB[i][j] = AB[i][j-1]+AB[i-1][j];
            }
        }
        
        return AB[A-1][B-1];
    }
}
