package com.rizstien.algos;

import java.util.HashMap;

public class RomanToInt {
	 public static int romanToInt(String A) {
	        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
	        map.put('I',1);
	        map.put('V',5);
	        map.put('X',10);
	        map.put('L',50);
	        map.put('C',100);
	        map.put('D',500);
	        map.put('M',1000);
	        
	        int prev = map.get(A.charAt(0));
	        int sum=0;
	        for(int i=0;i<A.length();i++){
	            int val = map.get(A.charAt(i));
	            if(prev<val){
	                sum = sum+(val-prev)-prev;
	            }else{
	                sum=sum+val;
	            }
	            prev=val;
	        }
	        return sum;
	    }
	public static void main(String[] args) {
		System.out.println(romanToInt("XII"));
	}

}
