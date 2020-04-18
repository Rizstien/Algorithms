package com.rizstien.algos;

import java.util.Stack;

public class RedundantBraces {
    public static int braces(String A) {
        Stack<Character> stack = new Stack<Character>();
        int count=0;
        for(char exp : A.toCharArray()){
            if(exp!=')'){
                stack.push(exp);
            }else if(exp==')'){
                if(stack.peek()=='(') return 1;
                while(stack.peek()!='('){
                    stack.pop();
                    count++;
                }
                if(count<2) return 1;
                else count=0;
                stack.pop();
            }
        }
        return 0;
    }
	
    public static void main(String[] args) {
    	System.out.println("Should return true : "+braces("(d+(a+b)+(c+d))"));
    	System.out.println("Should return false : "+braces("(d+(a+b)+(c))"));
    	System.out.println("Should return false : "+braces("(d+(a+b)+((c)))"));
	}

}
