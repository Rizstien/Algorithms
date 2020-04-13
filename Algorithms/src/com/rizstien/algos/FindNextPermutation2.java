package com.rizstien.algos;

import java.util.ArrayList;
import java.util.Collections;

public class FindNextPermutation2 {
	public static String nextPermutation(String str) {
		StringBuilder sb = new StringBuilder();
		ArrayList<Character> A = new ArrayList<Character>();
		for(char c : str.toCharArray()) {
			A.add(c);
		}
		
        int i = findConDecSeqBfrInd(A);
        if(i==0){
          Collections.reverse(A);
          for(char c : A) {
        	  sb.append(c);
          }
          return sb.toString();
        } 
        
        int j = findContDecSeqLstInd(A,i);
        Collections.swap(A,i,j);
        A = reverseAfterIndex(A,i);
        for(char c : A) {
      	  sb.append(c);
        }
        return sb.toString();
    }
     
    static int findConDecSeqBfrInd(ArrayList<Character> A){
        int indexI=0;
        for(int i=0;i<A.size()-1;i++){
            if(A.get(i)<A.get(i+1))
                indexI=i;
        }
        return indexI;
    }
    
    static int findContDecSeqLstInd(ArrayList<Character> A, int indexI){
        int indexj=0;
        for(int j=indexI+1;j<A.size();j++){
            if(A.get(j)>A.get(indexI))
                indexj=j;
        }
        return indexj;
    }
    
    static ArrayList<Character> reverseAfterIndex(ArrayList<Character> A, int index){
        Collections.reverse(A.subList(index+1,A.size()));
        return A;
    }
    
    static void swap(char[] A, int i, int j) {
    	char temp = A[i];
    	A[i] = A[j];
    	A[j] = temp;
    }
	
	public static void main(String[] args) {
		String str = "CBA";
		str = nextPermutation(str);
		System.out.println(str);
	}

}
