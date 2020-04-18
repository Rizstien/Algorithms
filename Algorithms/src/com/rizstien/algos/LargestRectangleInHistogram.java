package com.rizstien.algos;

import java.util.ArrayList;
import java.util.Stack;

public class LargestRectangleInHistogram {
    public static int largestRectangleArea(ArrayList<Integer> A) {
        if(A.size()==1) return A.get(0);
        int area = 0,i=0;
        Stack<Integer> stack = new Stack<Integer>();
        while(i<A.size()){
            if(stack.isEmpty() || A.get(stack.peek())<=A.get(i)){
                stack.push(i);
                i++;
            }else{
                int height = A.get(stack.pop());
                int width = stack.isEmpty()?i:i-stack.peek()-1;
                area = Math.max(area,height*width);
            }
        }
        
        while(!stack.isEmpty()){
            
            int height = A.get(stack.pop());
            int width = stack.isEmpty()?i:i-stack.peek()-1;
            area = Math.max(area,height*width);
        }
        
        return area;
    }
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(2);
		list.add(1);
		list.add(5);
		list.add(6);
		list.add(2);
		list.add(3);
		System.out.println(largestRectangleArea(list));

	}

}
