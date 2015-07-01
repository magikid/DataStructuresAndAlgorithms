package hw2;

public interface NodeInterface {
	public Node next();
	public void next(Node nextNode);
	public Node prev();
	public void prev(Node prevNode);
	public char value();
	public void value(char newValue);
}
