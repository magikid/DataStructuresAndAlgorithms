package hw2;

public class Node {
	public Object value;
	public Node next;
	public Node prev;
	
	public Node(Object givenValue){
		value = givenValue;
	}
	
	public Node(){
		value = '\0';
		prev = this;
		next = this;
	}
	
	public void next(Node nextNode){
		next = nextNode;
	}
	
	public Node next(){
		return next;
	}
	
	public void prev(Node prevNode){
		prev = prevNode;
	}
	
	public Node prev(){
		return prev;
	}
	
	public void value(Object newValue){
		value = newValue;
	}
	
	public Object value(){
		return value;
	}
}
