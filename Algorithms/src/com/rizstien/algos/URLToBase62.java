package com.rizstien.algos;

public class URLToBase62 {

	
	static String ToBase62(int number) {
		String alphabet = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		int n = number;
		int basis = 62;
		var ret = "";
		while (n > 0) {
		   int temp = n % basis;
		   ret = alphabet.charAt(temp) + ret;
		   n = (n / basis);
		}
		return ret;
	}
	
	public static void main(String[] args) {
		System.out.println(ToBase62(62));
	}

}
