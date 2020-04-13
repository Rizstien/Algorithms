package com.rizstien.algos;

public class LookAndSay {

	static void lookAndSay(int count){
		String val = "1";
		for(int i=0;i<count;i++) {
			System.out.println(val);
			val = buildSeq(val);
		}
	}
	
	static String buildSeq(String val) {
		if(val.length()==1) {
			return "11";
		}
		
		char first = val.charAt(0);
		Integer length=1;
		StringBuilder out = new StringBuilder();
		for(int i=1;i<val.length();i++) {
			char curr = val.charAt(i);
			if(first!=curr) {
				out.append(length).append(first);
				first=curr;
				length=1;
			}else{
				length++;
			}
		}
		out.append(length).append(first);
		return out.toString();
	}
	
	public static void main(String[] args) {
		lookAndSay(20);
	}

}
