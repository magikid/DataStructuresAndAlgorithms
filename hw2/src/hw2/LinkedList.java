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
	
	@Override
	public String toString(){
		Node nextNode = head();
		int counter = 1;
		StringBuilder output = new StringBuilder();
		output.append("Frontways\n================\n");
		output.append("Node\tPrev\tValue\tNext\n");
		while(nextNode != tail().next()){
			output.append(counter++ + "\t");
			output.append(nextNode.prev().value() + "\t"); 
			output.append(nextNode.value() + "\t");
			output.append(nextNode.next().value() + "\n");
			nextNode = nextNode.next();
		}
		output.append(counter++ + "\t");
		output.append(nextNode.prev().value() + "\t"); 
		output.append(nextNode.value() + "\t");
		output.append(nextNode.next().value() + "\n\n");
		
		output.append("Backways\n================\n");
		Node prevNode = tail();
		output.append("Node\tPrev\tValue\tNext\n");		
		counter--;
		while(prevNode != tail().next()){
			output.append((counter--) + "\t");
			output.append(prevNode.prev().value() + "\t"); 
			output.append(prevNode.value() + "\t");
			output.append(prevNode.next().value() + "\n");
			prevNode = prevNode.prev();
		}
		output.append((counter--) + "\t");
		output.append(nextNode.prev().value() + "\t"); 
		output.append(nextNode.value() + "\t");
		output.append(nextNode.next().value() + "\n\n");
		return output.toString();
	}
	
	public class NodeNotFound extends Exception{
		public NodeNotFound(){
			super("The given node wasn't found in the linked list");
		}
	}
}