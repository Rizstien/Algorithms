package com.rizstien.algos;

import java.util.ArrayList;
import java.util.Collections;

public class HighestProd {
    public int maxp3(ArrayList<Integer> A) {
        Collections.sort(A);
        int maxProd1 = A.get(A.size()-1) * A.get(A.size()-2) * A.get(A.size()-3);
        int maxProd2 = A.get(A.size()-1) * A.get(0) * A.get(1);
        
        return Math.max(maxProd1,maxProd2);
    }
}
