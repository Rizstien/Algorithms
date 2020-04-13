package com.rizstien.algos;

import java.util.List;

public class FindMinCircularSortedList {
    public int findMin(final List<Integer> a) {
        int n = a.size();
        int low=0, high=n-1;
        while(low<=high){
            if(a.get(low)<=a.get(high)) return a.get(low);
            int mid = low+(high-low)/2;
            int next = (mid+1)%n, prev = (mid+n-1)%n;
            if(a.get(mid)<=a.get(next) && a.get(mid)<=a.get(prev)) return a.get(mid);
            else if(a.get(mid)>=a.get(low)) low = mid+1;
            else if(a.get(mid)<=a.get(high)) high = mid-1;
        }
        return -1;
    }
}
