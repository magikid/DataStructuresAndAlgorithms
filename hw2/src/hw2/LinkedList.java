package hw2;

public class LinkedList implements LinkedListInterface {
	private Node sentinel; 
	
	public LinkedList(){
		sentinel = new Node();
	}

	@Override
	public Node insert(char newValue) {
		Node newNode = new Node(newValue);
		newNode.next(sentinel.next());
		if(sentinel.next() != sentinel){
			sentinel.prev(newNode);
		}
		sentinel.next(newNode);
		newNode.prev(sentinel);
		
		
		return newNode;
	}

	@Override
	public void delete(Node deletableNode) {
		deletableNode.prev().next(deletableNode.next());
		deletableNode.next().prev(deletableNode.prev());
	}

	@Override
	public Node search(char searchValue) {
		Node head = sentinel.next();
		while (head != sentinel && head.value() != searchValue) {
			head = head.next();
		}
		
		return head;
	}

}
