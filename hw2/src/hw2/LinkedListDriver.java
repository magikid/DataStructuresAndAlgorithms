package hw2;

public class LinkedListDriver {

	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		Node[] nodes = {
			new Node('a'),
			new Node('b'),
			new Node('c'),
			new Node('d'),
			new Node('e')
		};
		
		for (Node node : nodes) {
			ll.insert(node);
		}
		
		Node searchResults = ll.search(nodes[3]);
		ll.delete(searchResults);
	}

}
