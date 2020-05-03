package com.rizstien.algos;

public class RotationalCipher {
	static int characterType(char c){
	    if(c>=65 && c<=90) return 3;
	    else if(c>=97 && c<=122) return 2;
	    else if(c>=48 && c<=57) return 1;
	    else return 0;
	  }

	static String rotationalCipher(String input, int rotationFactor) {
	    char[] arr = input.toCharArray();
	    StringBuilder result = new StringBuilder();
	    for(char c : arr){
	      int type = characterType(c);
	      if(type==1){ 
	        int a = ((int) c)+(rotationFactor%10);
	        if(a>57) a=a-57+48-1;
	        result.append((char)a);
	      }
	      if(type==2){ 
	        int a = ((int) c)+(rotationFactor%26);
	        if(a>122) a=a-122+97-1;
	        result.append((char)a);
	      }
	      if(type==3){ 
	        int a = ((int) c)+(rotationFactor%26);
	        if(a>90) a=a-90+65-1;
	        result.append((char)a);
	      }
	      if(type==0){
	        result.append(c);
	      }
	    }
	    return result.toString();
	  }

	public static void main(String[] args) {
		System.out.println(rotationalCipher("All-convoYs-9-be:Alert1.",4)); //Epp-gsrzsCw-3-fi:Epivx5.
		System.out.println(rotationalCipher("abcdZXYzxy-999.@",200)); // stuvRPQrpq-999.@
	}

}
