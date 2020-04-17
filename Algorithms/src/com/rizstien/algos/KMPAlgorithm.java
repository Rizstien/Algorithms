package com.rizstien.algos;

public class KMPAlgorithm {
    public static int strStr(final String A, final String B) {
        int[] lps = computeLPSArray(B);
        
        int i=0;
        int j=0;
        while(i<A.length()){
            if(B.charAt(j)==A.charAt(i)){
                i++;j++;
            }
            
            if(j==B.length()){
                return i-j;
            }else if(i<A.length() && B.charAt(j)!=A.charAt(i)){
                if(j!=0) j=lps[j-1];
                else i++;
            }
        }
        return -1;
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
