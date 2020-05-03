package com.rizstien.algos;

public class TrailingZeros {
    public int trailingZeroes(int A) {
        int count = 0;
        int temp = 5;
        while((A/temp)!=0){
            count += A/temp;
            temp = temp*5;
        }
        return count;
    }
}
