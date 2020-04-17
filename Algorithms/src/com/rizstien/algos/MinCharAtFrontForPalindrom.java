package com.rizstien.algos;

public class MinCharAtFrontForPalindrom {
	public static int solve(String A) {
        StringBuilder sb = new StringBuilder(A);
        String reverse = sb.reverse().toString();
        int[] lps = computeLPSArray(sb.reverse().append("$").append(reverse).toString());
        return A.length() - lps[lps.length-1];
    }
	
	static int[] computeLPSArray(String s) { 
		// length of the previous longest prefix suffix 
		int[] lps = new int[s.length()];
		int len = 0; 
		int i = 1; 
		lps[0] = 0; // lps[0] is always 0 

		// the loop calculates lps[i] for i = 1 to M-1 
		while (i < s.length()) { 
			if (s.charAt(i) == s.charAt(len)) { 
				len++; 
				lps[i] = len; 
				i++; 
			}else{ // (pat[i] != pat[len]) 
				// This is tricky. Consider the example. 
				// AAACAAAA and i = 7. The idea is similar 
				// to search step. 
				if (len != 0) { 
					len = lps[len - 1]; 

					// Also, note that we do not increment 
					// i here 
				} else {// if (len == 0)  
					lps[i] = len; 
					i++; 
				} 
			} 
		}
		return lps;
	} 
	
	public static void main(String[] args) {
		int[] lps = computeLPSArray("ABCFABCFGHABCD");
		for(int e : lps)
			System.out.print(e+", ");
	}

}
