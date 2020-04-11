package com.rizstiem.algos;

import java.util.ArrayList;
import java.util.Stack;

public class MaxSpecialProduct {
public int maxSpecialProduct(ArrayList<Integer> A) {
        
        long[] leftSpVals = leftSpVal(A);
        long[] rightSpVals = rightSpVal(A);
        
        
        long maxProd=0;
        for(int i=0;i<A.size();i++){
            maxProd=Math.max(maxProd,rightSpVals[i]*leftSpVals[i]);
        }
        return (int) (maxProd % 1000000007);
    }
    
    long[] leftSpVal(ArrayList<Integer> A){
        int n=A.size();
        long[] leftSpVals = new long[A.size()];
        Stack<Integer> stk = new Stack<Integer>();
        for(int j=n-1;j>=0;j--){
            while(!stk.isEmpty() && A.get(j)>A.get(stk.peek())){
                int k = stk.pop();
                leftSpVals[k]=j;
            }
            stk.push(j);
        }
        return leftSpVals;
    }
    
    long[] rightSpVal(ArrayList<Integer> A){
        int n=A.size();
        long[] rightSpVals = new long[A.size()];
        Stack<Integer> stk = new Stack<Integer>();
        for(int j=0;j<n;j++){
            while(!stk.isEmpty() && A.get(j)>A.get(stk.peek())){
                int k = stk.pop();
                rightSpVals[k]=j;
            }
            stk.push(j);
        }
        return rightSpVals;
    }

}
