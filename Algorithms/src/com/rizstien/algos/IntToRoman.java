package com.rizstien.algos;

import java.util.LinkedList;
import java.util.List;

public class IntToRoman {
	static class Pair{
		int num;
		String roman;
		Pair(int num, String roman){
			this.num=num;
			this.roman=roman;
		}
	}
	 public static String IntToRoman(int A) {
	        List<Pair> list = new LinkedList<Pair>();
	        list.add(new Pair(1,"I"));
	        list.add(new Pair(4,"IV"));
	        list.add(new Pair(5,"V"));
	        list.add(new Pair(9,"IX"));
	        list.add(new Pair(10,"X"));
	        list.add(new Pair(40,"XL"));
	        list.add(new Pair(50,"L"));
	        list.add(new Pair(90,"XC"));
	        list.add(new Pair(100,"C"));
	        list.add(new Pair(400,"CD"));
	        list.add(new Pair(500,"D"));
	        list.add(new Pair(900,"CM"));
	        list.add(new Pair(1000,"M"));
	        
	        int n = list.size();
	        String s="";
	        int remain = A;
	        
	        for(int i=n-1; i>=0 && remain>0; i--){
	            
	            int divisor = list.get(i).num;
	            int divident = remain/divisor;
	            remain = remain%divisor;
	            
	            String temp="";
	            for(int j=0; j<divident; j++){
	                temp += list.get(i).roman;
	            }
	            s += temp;
	        }
	        return s;
	    }
	public static void main(String[] args) {
		System.out.println(IntToRoman(900));
	}

}
