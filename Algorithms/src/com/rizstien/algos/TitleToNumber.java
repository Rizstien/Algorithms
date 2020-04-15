package com.rizstien.algos;

public class TitleToNumber {
    public static int titleToNumber(String A) {
        int ans = 0;
        int n = A.length();

        for( int i=1;i<=n;i++ ){
            ans += Math.pow(26,n-i) * ( (int)A.codePointAt(i-1) - 64 );
        }
        return ans;
    }
    
	public static void main(String[] args) {
		System.out.println(titleToNumber("AZA"));
	}

}
