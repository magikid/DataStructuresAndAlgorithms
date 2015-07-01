package hw2;

public class Node {
	private char value;
	private Node next;
	private Node prev;
	
	public Node(char givenValue){
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
	
	public void value(char newValue){
		value = newValue;
	}
	
	public char value(){
		return value;
	}
}
