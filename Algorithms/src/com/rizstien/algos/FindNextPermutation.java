package com.rizstien.algos;

import java.util.ArrayList;
import java.util.Collections;

public class FindNextPermutation {
	public static ArrayList<Integer> nextPermutation(ArrayList<Integer> A) {
        int i = findConDecSeqBfrInd(A);
        if(i==0){
          Collections.reverse(A);
          return A;
        } 
        
        int j = findContDecSeqLstInd(A,i);
        Collections.swap(A,i,j);
        return reverseAfterIndex(A,i);
    }
     
    static int findConDecSeqBfrInd(ArrayList<Integer> A){
        int indexI=0;
        for(int i=0;i<A.size()-1;i++){
            if(A.get(i)<A.get(i+1))
                indexI=i;
        }
        return indexI;
    }
    
    static int findContDecSeqLstInd(ArrayList<Integer> A, int indexI){
        int indexj=0;
        for(int j=indexI+1;j<A.size();j++){
            if(A.get(j)>A.get(indexI))
                indexj=j;
        }
        return indexj;
    }
    
    static ArrayList<Integer> reverseAfterIndex(ArrayList<Integer> A, int index){
        Collections.reverse(A.subList(index+1,A.size()));
        return A;
    }
	
	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<Integer>();
		A.add(2);
		A.add(1);
		A.add(5);
		A.add(4);
		A.add(3);
		A = nextPermutation(A);
		A.forEach(e->System.out.print(e+", "));
	}

}
