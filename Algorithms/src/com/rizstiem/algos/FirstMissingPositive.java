package com.rizstiem.algos;

import java.util.ArrayList;
import java.util.Collections;

public class FirstMissingPositive {
    public int firstMissingPositive(ArrayList<Integer> A) {
        Collections.sort(A);
        int temp=0;
        for(int k=0;k<A.size();k++){
            if(A.get(k) == temp+1)
                temp = A.get(k);
        }
        return temp+1;
    }
}
