package com.rizstien.algos;

public class WaysToDecode {
    public int numDecodings(String A) {
        if (A.length() == 0)
            return 1;
        // invalid character
        if (A.charAt(0) == '0')
            return 0;
        if (A.length() == 1)
            return 1;
        int num = numDecodings(A.substring(1));
        // if decoding <= 26, split it into 2 decodings
        if (A.charAt(0) == '1' || A.charAt(0) == '2' && A.charAt(1) <= '6')
            num += numDecodings(A.substring(2));
        return num;
        
    }
}

