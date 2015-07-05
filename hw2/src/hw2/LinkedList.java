package hw2;

public class LinkedList implements LinkedListInterface{
	private Node sentinel; 
	
	public LinkedList(){
		sentinel = new Node();
	}

	public Node insert(Node newNode) {
		newNode.next(head());
		newNode.prev(sentinel);
		
		head().prev(newNode);
		head(newNode);
		
		if (tail() == sentinel) {
			tail(newNode);
		}
				
		return newNode;
	}
	
	public Node insert(Node newNode, Runnable callback) {
		Node temp = insert(newNode);
		
		callback.run();
		return temp;
	}
	
	public Node insert(Node newNode, Node insertAfter, Runnable callback) throws NodeNotFound {
		Node foundNode = search(insertAfter);
		newNode.prev(foundNode);
		newNode.next(foundNode.next());
		
		foundNode.next().prev(newNode);
		foundNode.next(newNode);
		
		callback.run();
		return newNode;
	}

	public void delete(Node deletableNode) {
		deletableNode.prev().next(deletableNode.next());
		deletableNode.next().prev(deletableNode.prev());
		if(tail() == deletableNode){
			tail(deletableNode.prev());
		}
		deletableNode = null;
	}
	
	public void delete(Node deletableNode, Runnable callback) {
		delete(deletableNode);
		callback.run();
	}

	public Node search(Node searchNode) throws NodeNotFound {
		Node nextNode = head();
		while (nextNode != sentinel) {
			if (nextNode.value() == searchNode.value()) {
				return nextNode;
			}else{
				nextNode = nextNode.next();
			}
		}
		
		throw new NodeNotFound();
	}
	
	public Node search(Node searchNode, Runnable callback) throws NodeNotFound{
		Node returnNode = search(searchNode);
		
		callback.run();
		return returnNode;
	}
	
	public Node head(){
		return sentinel.next();
	}
	
	public Node tail(){
		return sentinel.prev();
	}
	
	private void head(Node newHead){
		sentinel.next(newHead);
	}
	
	private void tail(Node newTail){
		sentinel.prev(newTail);
	}
	
	public class NodeNotFound extends Exception{
		public NodeNotFound(){
			super("The given node wasn't found in the linked list");
		}
	}
}