package com.rizstien.algos;

import java.util.ArrayList;

public class MinStepsInfiniteGrid {
    public static int coverPoints(ArrayList<Integer> A, ArrayList<Integer> B) {
        int xStart = A.get(0);
        int yStart = B.get(0);
        int xEnd = xStart;
        int yEnd = yStart;
        int xDiff = 0;
        int yDiff = 0;
        int steps=0;
        
        for(int i=1;i<A.size();i++){
            xEnd = A.get(i);
            yEnd = B.get(i);
            
            xDiff = Math.abs(xEnd - xStart);
            yDiff = Math.abs(yEnd - yStart);
            steps = steps+Math.max(xDiff,yDiff);
            xStart = xEnd;
            yStart = yEnd;
        }
        return steps;
    }
	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<Integer>();
		A.add(0);
		A.add(1);
		A.add(1);
		A.add(-1);
		
		ArrayList<Integer> B = new ArrayList<Integer>();
		B.add(0);
		B.add(1);
		B.add(2);
		B.add(-2);
		
		coverPoints(A, B);

	}

}
