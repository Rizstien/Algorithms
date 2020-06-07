package com.rizstien.algos;

public class Flip {
	public static int[] flip(String str) {
        
        int[] result = new int[2];
        
        int[] num = new int[str.length()];
        int count = 0;
        
        // mark 0s to 1 and 1s to -1
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i)=='1'){
                num[i] = -1;
                count++;
            }else{
                num[i] = 1;
            }
        }
        
        if(count==str.length()) return new int[0];
        
        int l = 0, r = 0;
        int max = num[0];
        int runningSum = num[0];
        int current;
        int start = 0;
        
        for (int i = 1; i < num.length; i++) {
            current = num[i];
            if (runningSum + current < current) {
                runningSum = current;
                start = i;
            } else {
                runningSum = runningSum + current;
            }
            
            if (runningSum > max) {
                max = runningSum;
                l = start;
                r = i;
            }
        }

        result[0] = l+1;
        result[1] = r+1;
        return result;      
    }
	
	public static void main(String[] args) {
		flip("0110101");
	}

}
