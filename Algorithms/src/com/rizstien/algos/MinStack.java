package com.rizstien.algos;

import java.util.Stack;

public class MinStack {
    Stack<Integer> stack = new Stack<Integer>();
    Stack<Integer> minStack = new Stack<Integer>();
    
    public void push(int x) {
        stack.push(x);
        if(minStack.isEmpty() || x<=minStack.peek()) minStack.push(x);
    }

    public void pop() {
        if(!minStack.isEmpty() && stack.peek().equals(minStack.peek())) minStack.pop();
        if(!stack.isEmpty()) stack.pop();
    }

    public int top() {
        if(!stack.isEmpty()) return stack.peek();
        else return -1;
    }

    public int getMin() {
        if(!minStack.isEmpty()) return minStack.peek();
        else return -1;
    }

}
