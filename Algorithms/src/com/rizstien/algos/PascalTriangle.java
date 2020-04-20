package com.rizstien.algos;

import java.util.ArrayList;

public class PascalTriangle {
	public static ArrayList<ArrayList<Integer>> solve(int A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> resultLoc = new ArrayList<Integer>();
        ArrayList<Integer> resultPrev = new ArrayList<Integer>();
        if(A==0) return result;
        else if(A==1) {
            resultLoc.add(1);
            result.add(resultLoc);
            return result;
        }else if(A==2){
            resultLoc = new ArrayList<Integer>();
            resultLoc.add(1);
            result.add(resultLoc);
            resultLoc = new ArrayList<Integer>();
            resultLoc.add(1);
            resultLoc.add(1);
            result.add(resultLoc);
            //System.out.println(result.size());
            return result;
        }else{
            for(int i=3;i<=A;i++){
                result = solve(i-1);
                resultLoc = new ArrayList<Integer>();
                resultLoc.add(1);
                resultPrev = result.get(i-2);
                for(int j=0;j<resultPrev.size()-1;j++){
                    resultLoc.add(resultPrev.get(j)+resultPrev.get(j+1));
                }
                resultLoc.add(1);
            }
            result.add(resultLoc);
        }
        return result;
    }
	public static void main(String[] args) {
		solve(5);
	}

}
