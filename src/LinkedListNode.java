class LinkedListNode {
	int data;
	LinkedListNode next;

	public LinkedListNode(int data) {
		this.data = data;
	}

	public static void printSingleLinkedList(LinkedListNode head) {
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
