package com.rizstien.algos;

public class URLShortner {

	public static String idToShortURL(int n) {
		StringBuilder shortUrl  = new StringBuilder();
		
		char[] map = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
		while(n>0) {
			shortUrl.append(map[n%62]);
			n = n/62;
		}		
		return shortUrl.reverse().toString();
	}
	
	public static int shortURLToId(String shortUrl) {
		int id = 0;
		for(int i=0;i<shortUrl.length();i++) {
			if(shortUrl.charAt(i)>='a' && shortUrl.charAt(i)<='z') {
				id = id*62+shortUrl.charAt(i)-'a';
			}
			if(shortUrl.charAt(i)>='A' && shortUrl.charAt(i)<='Z') {
				id = id*62+shortUrl.charAt(i)-'A'+26;
			}
			if(shortUrl.charAt(i)>='0' && shortUrl.charAt(i)<='9') {
				id = id*62+shortUrl.charAt(i)-'0'+52;
			}
		}

		return id;
	}
	
	public static void main(String[] args) {
		System.out.println(idToShortURL(1234567890));
		System.out.println(shortURLToId(idToShortURL(1234567890)));
	}

}
