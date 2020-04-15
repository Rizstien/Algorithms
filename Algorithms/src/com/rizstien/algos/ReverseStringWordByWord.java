package com.rizstien.algos;

public class ReverseStringWordByWord {
    public static String solve(String A) {
        StringBuilder sb = new StringBuilder(A.trim());
        StringBuilder result = new StringBuilder();
        while(sb.length()>0){
            result.append(findLastWord(sb)).append(" ");
        }
        return result.toString();
    }
    
    static String findLastWord(StringBuilder sb){
        String result = "";
        int endIndex=-1,startIndex=-1;
        for(int i=sb.length()-1;i>=0;i--){
            if(endIndex==-1 && sb.charAt(i)!=' '){
                endIndex = i;
            }
            if(endIndex!=-1 && (sb.charAt(i)==' ' || i==0)){
                if(i==0) startIndex=i;
                else startIndex=i+1;
                result = sb.substring(startIndex,endIndex+1);
                sb.delete(startIndex,sb.length());
                return result;
            }
        }
        return result;
    }
    
	public static void main(String[] args) {
		System.out.println(solve("   the sky   is blue  "));
	}

}
