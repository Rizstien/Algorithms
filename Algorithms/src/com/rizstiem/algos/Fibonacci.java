package com.rizstiem.algos;

import java.util.HashMap;

public class Fibonacci {

	static HashMap<Integer, Integer> mem = new HashMap<Integer, Integer>();
	static int fibonacci(int n) {
		if(n<=0) {
			return 0;
		}else if(n==1) {
			return 1;
		}else {
			if(mem.containsKey(n)) {
				return mem.get(n);
			}
			mem.put(n,fibonacci(n-1)+fibonacci(n-2));
			return fibonacci(n-1)+fibonacci(n-2);
		}
		
	}
	
	public static void main(String[] args) {
		System.out.println(fibonacci(6));
	}

}
