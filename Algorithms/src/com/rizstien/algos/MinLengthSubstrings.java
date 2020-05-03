package com.rizstien.algos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MinLengthSubstrings {
	static int minLengthSubstring(String s, String t) {
		if(t.length()>s.length()) return -1;
		Map<Character, Integer> map = new HashMap<Character,Integer>();
		ArrayList<Integer> result = new ArrayList<Integer>();
		for(int i=0;i<t.length();i++){
			if(!map.containsKey(t.charAt(i))){
				if(s.indexOf(t.charAt(i))==-1) return -1;
				map.put(t.charAt(i),s.indexOf(t.charAt(i)));
				result.add(s.indexOf(t.charAt(i)));
			}else{
				if(s.indexOf(t.charAt(i),map.get(t.charAt(i))+1)==-1) return -1;
				map.put(t.charAt(i),s.indexOf(t.charAt(i),map.get(t.charAt(i))+1));
				result.add(s.indexOf(t.charAt(i),map.get(t.charAt(i))));
			}
		}
		Collections.sort(result);
		return result.get(result.size()-1)-result.get(0)+1;
	}
	
	public static void main(String[] args) {	    
		minLengthSubstring("bfbeadbcbcbfeaaeefcddcccbbbfaaafdbebedddf", "cbccfafebccdccebdd");
		minLengthSubstring("dcbefebce", "fd");
	}

}
