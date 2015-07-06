package hw2;

import hw2.LinkedList.NodeNotFound;

public interface LinkedListInterface {
	public Node insert(Node newNode);
	public Node insert(Node newNode, Runnable callback);
	public void delete(Node deletableNode);
	public void delete(Node deletableNode, Runnable callback);
	public Node search(Node searchNode) throws NodeNotFound;
	public Node search(Node searchNode, Runnable callback) throws NodeNotFound;
}
