package com.rizstien.algos;

public class EncryptedWords {
	static String encrypt(String s) {
	    StringBuilder result = new StringBuilder();
	    if(s.length()==1 || s.length()==2) return s;
	    int low=0,high=s.length()-1;
	    int mid=low+(high-low)/2;
	    return result.append(s.charAt(mid))
	      .append(encrypt(s.substring(0,mid)))
	      .append(encrypt(s.substring(mid+1,s.length())))
	      .toString();
	}
		  
	static String findEncryptedWord(String s) {
		return encrypt(s);
	}
	
	public static void main(String[] args) {
		System.out.println(findEncryptedWord("abc")); //bac
		System.out.println(findEncryptedWord("abcd")); //bacd
		System.out.println(findEncryptedWord("abcxcba")); //xbacbca
		System.out.println(findEncryptedWord("facebook")); //eafcobok

	}

}
