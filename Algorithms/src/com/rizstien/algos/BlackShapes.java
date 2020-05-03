package com.rizstien.algos;

import java.util.ArrayList;
import java.util.Arrays;

public class BlackShapes {
	public static int black(ArrayList<String> A) {
        int count=0;
        int n = A.size();
        int m = A.get(0).length();
        int[][] visited = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(A.get(i).charAt(j)=='X' && visited[i][j]==0){
                    count++;
                    bfs(A,i,j,visited);
                }
            }
        }
        return count;
    }
    
    static void bfs(ArrayList<String> A, int i, int j, int[][] visited){
        if(i<0 || j<0 || i>A.size()-1 || j>A.get(0).length()-1 
            || A.get(i).charAt(j)=='O' || visited[i][j]==1) return ;
            
        visited[i][j]=1;
        bfs(A,i+1,j,visited);
        bfs(A,i-1,j,visited);
        bfs(A,i,j+1,visited);
        bfs(A,i,j-1,visited);
    }
    
    public static void main(String[] args) {
    	ArrayList<String> input = new ArrayList<String>(Arrays.asList("OOOXOOO","OOXXOXO","OXOOOXO"));
    	System.out.println(black(input));
    }
}
