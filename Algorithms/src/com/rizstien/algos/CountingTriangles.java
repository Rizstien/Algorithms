package com.rizstien.algos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class CountingTriangles {
	static class Sides{
	    int a;
	    int b;
	    int c;
	    Sides(int a,int b,int c){
	      this.a = a;
	      this.b = b;
	      this.c = c; 
	    }
		/*
		 * public boolean equals(Sides obj) { if(this.a==obj.a && this.b==obj.b &&
		 * this.c==obj.c) return true; return false; }
		 * 
		 * @Override public int hashCode() { return super.hashCode(); }
		 */
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + a;
			result = prime * result + b;
			result = prime * result + c;
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Sides other = (Sides) obj;
			if (a != other.a)
				return false;
			if (b != other.b)
				return false;
			if (c != other.c)
				return false;
			return true;
		}
	 }
	  
	  static Sides swap(Sides s, char first, char second){
		  if(first=='a' && second=='b') {
			  int temp = s.a;
			  s.a = s.b;
			  s.b = temp;			  
		  }
		  
		  else if(first=='b' && second=='c') {
			  int temp = s.b;
			  s.b = s.c;
			  s.c = temp;			  
		  }
		  
		  else if(first=='a' && second=='c') {
			  int temp = s.a;
			  s.a = s.c;
			  s.c = temp;			  
		  }
		  return s;
	  }
	  
	  
	  static int countDistinctTriangles(ArrayList<Sides> arr) {
	    Collections.sort(arr,new Comparator<Sides>(){
	      public int compare(Sides s1, Sides s2){
	    	  while(s1.a>s1.b || s1.b>s1.c || s1.a>s1.c) {
	    		  if(s1.a>s1.b) s1=swap(s1,'a','b');
	    		  if(s1.b>s1.c) s1=swap(s1,'b','c');
	    		  if(s1.a>s1.c) s1=swap(s1,'a','c');
	    	  }
	    	  
	    	  while(s2.a>s2.b || s2.b>s2.c || s2.a>s2.c) {
	    		  if(s2.a>s2.b) s2=swap(s2,'a','b');
	    		  if(s2.b>s2.c) s2=swap(s2,'b','c');
	    		  if(s2.a>s2.c) s2=swap(s2,'a','c');
	    	  }
	        
	        return s1.a-s2.a;
	      }
	    });
	    
	    Set<Sides> set = new HashSet<Sides>();
	    for(Sides sides : arr){
	      set.add(sides);
	    }
	    return set.size();
	  }
	  
	  public static void main(String args[]) {
		  ArrayList<Sides> arr = new ArrayList<Sides>();
		  arr.add(new Sides(7, 6, 5));
		  arr.add(new Sides(5, 7, 6));
		  arr.add(new Sides(8, 2, 9));
		  arr.add(new Sides(2, 3, 4));
		  arr.add(new Sides(2, 4, 3));
		  System.out.println(countDistinctTriangles(arr));
	  }
}
