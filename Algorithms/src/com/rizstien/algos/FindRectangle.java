package com.rizstien.algos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindRectangle {
	public int solve(final List<ArrayList<Integer>> A) {
        int x = -1,y = -1;
        int comb;
        Set<Integer> set = new HashSet<Integer>();
        
        for(int i=0;i<A.size();i++){
            x=-1;y=-1;
            for(int j=0;j<A.get(0).size();j++){
                if(A.get(i).get(j)==1){
                    if(x==-1){
                        x = j;
                    }
                    else if(x!=-1 && y==-1){
                        y = j;
                    }
                    if(x!=-1 && y!=-1){
                       comb = x+(y%5)*5;
                       if(set.contains(comb)) return 1;
                       set.add(comb);
                    }
                }
            }
        }
        return 0;
    }
}
