package com.rizstiem.algos;

import java.util.ArrayList;

public class RotateMatrix {
	
    public void rotate(ArrayList<ArrayList<Integer>> a) {
        int n = a.size();
        for (int i = 0; i < n / 2; i++) { 
            for (int j = i; j < n - i - 1; j++) { 
          
                // Swap elements of each cycle 
                // in clockwise direction 
                int temp = a.get(i).get(j); 
                a.get(i).set(j,a.get(n - 1 - j).get(i)); 
                a.get(n - 1 - j).set(i,a.get(n - 1 - i).get(n - 1 - j)); 
                a.get(n - 1 - i).set(n - 1 - j,a.get(j).get(n - 1 - i)); 
                a.get(j).set(n - 1 - i, temp); 
            } 
        } 
    } 
}

