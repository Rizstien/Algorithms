package com.rizstien.algos;

class ReverseSublist {
	class Node {
		int data;
		Node next;

		Node(int x) {
			data = x;
			next = null;
		}
	}

	Node reverseSublist(Node start, Node end) {
		Node next = null, prev = null;
		Node curr = start;
		while (curr != end) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}

	Node reverse(Node head) {
		Node curr = head;
		Node A, B, C, D;
		while (curr != null && curr.next != null) {
			if (curr.next.data % 2 == 0) {
				A = curr;
				B = curr.next;
				while (curr.next != null && curr.next.data % 2 == 0) {
					curr = curr.next;
				}
				C = curr;
				D = curr.next;
				if (A.data % 2 != 0 && B != C) {
					C = reverseSublist(B, D);
					A.next = C;
					B.next = D;
				} else {
					head = reverseSublist(A, D);
					A.next = D;
				}
				curr = D;
			} else {
				curr = curr.next;
			}
		}
		return head;
	}

	// These are the tests we use to determine if the solution is correct.
	// You can add your own at the bottom, but they are otherwise not editable!
	int test_case_number = 1;

	void printLinkedList(Node head) {
		System.out.print("[");
		while (head != null) {
			System.out.print(head.data);
			head = head.next;
			if (head != null)
				System.out.print(" ");
		}
		System.out.print("]");
	}

	void check(Node expectedHead, Node outputHead) {
		boolean result = true;
		Node tempExpectedHead = expectedHead;
		Node tempOutputHead = outputHead;
		while (expectedHead != null && outputHead != null) {
			result &= (expectedHead.data == outputHead.data);
			expectedHead = expectedHead.next;
			outputHead = outputHead.next;
		}
		if (!(expectedHead == null && outputHead == null))
			result = false;

		char rightTick = '\u2713';
		char wrongTick = '\u2717';
		if (result) {
			System.out.println(rightTick + " Test #" + test_case_number);
		} else {
			System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
			printLinkedList(tempExpectedHead);
			System.out.print(" Your output: ");
			printLinkedList(tempOutputHead);
			System.out.println();
		}
		test_case_number++;
	}

	Node createLinkedList(int[] arr) {
		Node head = null;
		Node tempHead = head;
		for (int v : arr) {
			if (head == null) {
				head = new Node(v);
				tempHead = head;
			} else {
				head.next = new Node(v);
				head = head.next;
			}
		}
		return tempHead;
	}

	public void run() {

		  int[] arr_1 = {1, 2, 4, 8, 9, 12, 14, 16}; int[] expected1 = {1, 8, 4, 2, 9,
		  16, 14, 12}; Node head_1 = createLinkedList(arr_1); Node expected_1 =
		  createLinkedList(expected1); Node output_1 = reverse(head_1);
		  check(expected_1, output_1);
		 

		int[] arr_2 = { 2, 18, 24, 3, 5, 7, 9, 6, 12 };
		int[] expected2 = { 24, 18, 2, 3, 5, 7, 9, 12, 6 };
		Node head_2 = createLinkedList(arr_2);
		Node expected_2 = createLinkedList(expected2);
		Node output_2 = reverse(head_2);
		check(expected_2, output_2);

		int[] arr_3 = { 2, 8, 12, 16 };
		int[] expected3 = { 16, 12, 8, 2 };
		Node head_3 = createLinkedList(arr_3);
		Node expected_3 = createLinkedList(expected3);
		Node output_3 = reverse(head_3);
		check(expected_3, output_3);
	}

	public static void main(String[] args) {
		new ReverseSublist().run();
	}
}