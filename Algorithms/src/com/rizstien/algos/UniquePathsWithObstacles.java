package com.rizstien.algos;
public class UniquePathsWithObstacles {
    public int uniquePathsWithObstacles(int[][] A) {
        
        if(A[0][0]==1) return 0;
        
        int m=A.length;
        int n=A[0].length;
        int[][] path = new int[m][n];
        
        path[0][0]=1;
        
        for(int i=1;i<m;i++){
            if (A[i][0] == 0) path[i][0]=path[i-1][0];
        }
        
        for(int j=1;j<n;j++){
            if (A[0][j] == 0) path[0][j]=path[0][j-1];
        }
        
        
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if (A[i][j] == 0)
                    path[i][j] = path[i-1][j]+path[i][j-1];
            }
        }
        
        return path[m-1][n-1];
    }
}

