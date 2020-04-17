package com.rizstien.algos;

public class LengthOfLastWord {
    public static int lengthOfLastWord(final String A) {
        if(A.trim().length()==0) return 0;
        String word = findLastWord(A.trim());
        return word.length();
    }
    
    static String findLastWord(String A){
        int end=-1;
        int start=-1;
        for(int i=A.length()-1;i>=0;i--){
            if(end==-1 && A.charAt(i)!=' '){
                end=i;
            }
            if(end!=-1 && (A.charAt(i)==' ' || i==0)){
                if(i==0) start=i;
                else start=i+1;
                return A.substring(start,end+1);
            }
        }
        return "";
    }
	public static void main(String[] args) {
		System.out.println(lengthOfLastWord("Heloo World"));
	}

}
