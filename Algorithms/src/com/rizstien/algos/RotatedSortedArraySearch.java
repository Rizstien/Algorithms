package com.rizstien.algos;

import java.util.ArrayList;
import java.util.List;

public class RotatedSortedArraySearch {
	public int search(final List<Integer> A, int B) {
        int min = findMin(A);
        int low=0, high=A.size()-1;
        if(min==-1) return -1;
        else if(A.get(min)==B) return min;
        
        int result = searchInsortedList(A,low,min-1,B);
        if(result==-1){
            return searchInsortedList(A,min+1,high,B);
        }else{
            return result;
        }
    }
    
    public int searchInsortedList(List<Integer> A, int low, int high, int B){
        while(low<=high){
            int mid = low+(high-low)/2;
            if(A.get(mid)==B) return mid;
            else if(A.get(mid)>B) high = mid-1;
            else if(A.get(mid)<B) low = mid+1;
        }
        return -1;
    }
    
    public int findMin(List<Integer> a) {
        int n = a.size();
        int low=0, high=n-1;
        while(low<=high){
            if(a.get(low)<=a.get(high)) return low;
            int mid = low+(high-low)/2;
            int next = (mid+1)%n, prev = (mid+n-1)%n;
            if(a.get(mid)<=a.get(next) && a.get(mid)<=a.get(prev)) return mid;
            else if(a.get(mid)>=a.get(low)) low = mid+1;
            else if(a.get(mid)<=a.get(high)) high = mid-1;
        }
        return -1;
    }
	
	public static void main(String[] args) {
		RotatedSortedArraySearch obj = new RotatedSortedArraySearch();
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(0);
		list.add(1);
		list.add(2);
		list.add(3);
		System.out.println(obj.search(list,6));

	}

}
