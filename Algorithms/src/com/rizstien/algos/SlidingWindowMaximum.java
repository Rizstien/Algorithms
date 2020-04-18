package com.rizstien.algos;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class SlidingWindowMaximum {
	public static ArrayList<Integer> slidingMaximum(final List<Integer> A, int B)  {
        Deque<Integer> window = new LinkedList<Integer>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < A.size(); i++) {
            int val = A.get(i);
            // Remove all elements smaller than the current one from the queue
            while (!window.isEmpty() && val >= A.get(window.getLast())) {
                window.removeLast();
            }
            // Add the current element's index to the queue. It is important that we
            // store the indicies rather than the values.
            window.add(i);
            // The first element of the queue is always the largest. If the index of 
            // this number is smaller than the window's stating index then we remove it
            if (window.getFirst() < (i + 1) - B) {
                window.removeFirst();
            }
            // Ignores the first few iterations
            if (i >= B - 1)
                result.add(A.get(window.getFirst()));
        }
        return result;
    }
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(3);
		list.add(-1);
		list.add(-3);
		list.add(5);
		list.add(3);
		list.add(6);
		list.add(7);
		System.out.println(slidingMaximum(list,3));
	}

}
