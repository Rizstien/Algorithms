

class SinglyLinkedListNode {
    int data;
    SinglyLinkedListNode next;
}

public class LinkedListHasCycle {
	    // Complete the hasCycle function below.

	    /*
	     * For your reference:
	     *
	     * SinglyLinkedListNode {
	     *     int data;
	     *     SinglyLinkedListNode next;
	     * }
	     *
	     */
	    static boolean hasCycle(SinglyLinkedListNode head) {
	            if(head==null) return false;

	            SinglyLinkedListNode fast = head.next;
	            SinglyLinkedListNode slow = head;

	            while(fast!=null && fast.next!=null && slow!=null){
	                if(fast==slow){
	                    return true;
	                }
	                fast=fast.next.next;
	                slow=slow.next;
	            }
	            return false;
	    }
	
}
