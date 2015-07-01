package hw2;

public class LinkedList implements LinkedListInterface {
	private Node sentinel; 
	
	public LinkedList(){
		sentinel = new Node();
	}

	public Node insert(Node newNode) {
		newNode.next(head());
		if(head() != sentinel){
			sentinel.prev(newNode);
		}
		head(newNode);
		newNode.prev(sentinel);
		
		printList();
		return newNode;
	}

	public void delete(Node deletableNode) {
		deletableNode.next().prev(deletableNode.prev());
		deletableNode.prev().next(deletableNode.next());
		printList();
	}

	public Node search(Node searchNode) {
		Node nextNode = head();
		while (nextNode != sentinel && nextNode.value() != searchNode.value()) {
			nextNode = nextNode.next();
		}
		
		System.out.println(nextNode.value());
		return nextNode;
	}
	
	private Node head(){
		return sentinel.next();
	}
	
	private void head(Node newHead){
		sentinel.next(newHead);
	}
	
	private void printList(){
		Node nextNode = head();
		StringBuilder output = new StringBuilder();
		
		while(nextNode != sentinel){
			output.append(nextNode.value() + "\t");
			nextNode = nextNode.next();
		}
		System.out.println(output.toString());
	}
}