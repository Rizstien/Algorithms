package com.rizstien.algos;
public class FrogRiverOne {
    static int solution(int X, int[] A) {
    	int steps = X;
        boolean[] bitmap = new boolean[steps+1];
        for(int i = 0; i < A.length; i++){
            if(!bitmap[A[i]]){
                bitmap[A[i]] = true;
                steps--;
            }
            if(steps == 0) return i;
        }
        return -1;		
    }

    public static void main(String[] args) {
        System.out.println(solution(5, new int[] {1,3,2,5,4}));
    }
}