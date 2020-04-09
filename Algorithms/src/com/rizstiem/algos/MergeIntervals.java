package com.rizstiem.algos;

import java.util.ArrayList;
import java.util.Collections;

public class MergeIntervals {
	
	 static class Interval implements Comparable<Interval>{
	     int start;
	     int end;
	     Interval() { start = 0; end = 0; }
	     Interval(int s, int e) { start = s; end = e; }
	     public int compareTo(Interval interval){
	         return this.start - interval.start;
	     }
	  }
	 
	 public static ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
	    ArrayList<Interval> newList = new ArrayList<Interval>(); 
	    intervals.add(newInterval);
	    Collections.sort(intervals);
		        
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
		        
        for(int i=1;i<intervals.size();i++){
            if(intervals.get(i).start <= end){
                if(intervals.get(i).end>=end){
                    end=intervals.get(i).end;
                }else{
                    continue;
                }
            }else{
                newList.add(new Interval(start, end));
                start=intervals.get(i).start;
                end=intervals.get(i).end;
            }
        }
        newList.add(new Interval(start, end));
        return newList;
	}

	public static void main(String[] args) {
		ArrayList<Interval> list = new ArrayList<Interval>();
		list.add(new Interval(1,3));
		list.add(new Interval(6,9));
		insert(list,new Interval(2,7));
	}

}
