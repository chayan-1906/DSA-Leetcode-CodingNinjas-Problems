public class Node {
	int data;
	Node next;

	Node random;

	Node(int data) {
		this.data = data;
		this.next = null;
		this.random = null;
	}

	public static void printSingleLinkedList(Node head) {
		if (head != null) {
			while (head.next != null) {
				System.out.print ( head.data + " --> " );
				head = head.next;
			}
			System.out.println ( head.data + " --> null" );
		} else {
			System.out.println ( "null..." );
			System.out.println ( "Empty Linked List" );
		}
	}
}
