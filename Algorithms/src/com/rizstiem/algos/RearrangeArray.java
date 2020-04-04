package com.rizstiem.algos;

import java.util.ArrayList;

public class RearrangeArray {
    public void arrange(ArrayList<Integer> a) {
        int n=a.size();
        for(int i=0;i<n;i++){
            int x=a.get(i);
            int y=a.get(a.get(i));
            a.set(i,x+(y%n)*n);
        }
        
        for(int j=0;j<n;j++){
            a.set(j,a.get(j)/n);
        }
    }
}

