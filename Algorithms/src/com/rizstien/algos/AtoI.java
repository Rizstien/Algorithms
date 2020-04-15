package com.rizstien.algos;

public class AtoI {
	public static int atoi(final String A) {
        StringBuilder sb = new StringBuilder();
        if(checkGarbageFirst(A)){
          return 0;  
        } 
        int i=0;
        while(A.charAt(i)==' ') i++;
        
        while(i<A.length()){
            if(isNumeric(A.charAt(i))) {
                sb.append(A.charAt(i));
                i++;
            }else{
                break;
            }
        }
        if(sb.length()==1 && (sb.charAt(0)=='-' || sb.charAt(0)=='+')) return 0;
        try{
            return Integer.valueOf(sb.toString());
        }catch(NumberFormatException ex){
            if(sb.charAt(0)=='-') return Integer.MIN_VALUE;
            else return Integer.MAX_VALUE;
        }
	}
        
    static boolean isNumeric(char c1){
        if(c1=='-' || c1=='+' || c1>='0' && c1<='9') return true;
        else return false;
    }
        
    static boolean checkGarbageFirst(String A){
        for(int i=0;i<A.length();i++){
            if(A.charAt(i)==' ') continue;
            if(!isNumeric(A.charAt(i))){
                return true;
            }else{
                return false;
            }
        }
        return false;
    }
	
	public static void main(String[] args) {
		System.out.println(atoi("+7 U 7689"));
	}

}
