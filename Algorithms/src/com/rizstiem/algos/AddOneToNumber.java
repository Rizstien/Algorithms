package com.rizstiem.algos;

import java.util.ArrayList;

public class AddOneToNumber {
	public static ArrayList<Integer> plusOne(ArrayList<Integer> A) {
        if(A.get(0)!=0){
            A.add(0,0);
        }
        Integer lsd = A.get(A.size()-1);
        Integer updNum = lsd+1;
        if(updNum==10){
            A.set(A.size()-1,0);
            for(int i=A.size()-2;i>=0;i--){
                if(A.get(i)+1==10){
                    A.set(i,0);
                }else{
                    A.set(i,A.get(i)+1);
                    break;
                }
            }
        }else{
            A.set(A.size()-1,updNum);
        }
        
        while(A.get(0)==0){
            A.remove(0);
        }
        return A;
    }
	
	public static void main(String[] args){
		ArrayList<Integer> arrList = new ArrayList<Integer>();
		arrList.add(0);
		arrList.add(0);
		arrList.add(9);
		arrList.add(9);
		arrList.add(9);
		arrList.add(9);
		arrList.add(9);
		arrList.add(9);
		arrList.add(9);
		arrList.add(9);
		plusOne(arrList);
		
	}

}
