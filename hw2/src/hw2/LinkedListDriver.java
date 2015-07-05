package hw2;

import hw2.LinkedList.NodeNotFound;

import java.awt.print.Printable;

public class LinkedListDriver {	
	public static void main(String[] args) {
		
		LinkedList ll = new LinkedList();

		/*
		 * This is an implementation of the Runnable class that can 
		 * be passed to the insert(), delete(), or search() methods 
		 * which will in turn run it.  I really wanted to pass in an
		 * anonymous function to print out the list.
		 */
		Runnable printList = new Runnable(){
			@Override
			public void run(){
				System.out.println(ll.toString());
			}
		};
		
		Node[] nodes = {
			new Node('a'),
			new Node('b'),
			new Node('c'),
			new Node('d'),
			new Node('e')
		};
		
		// Push nodes onto the head of the list 
		for (Node node : nodes) {
			ll.insert(node, printList);
		}
		
		// Insert a node after a specified node
		try {
			ll.insert(new Node("aa"), nodes[1], printList);
		} catch (NodeNotFound e) {
			e.printStackTrace();
		}
		
		
		// I picked the first element to find and delete since that's an edge case. 
		Node searchResults;
		try {
			searchResults = ll.search(new Node("g"), printList);
			ll.delete(searchResults, printList);
		} catch (NodeNotFound e) {
			e.printStackTrace();
		}
		
		// Just to show that the list operates correctly after a delete.
		ll.insert(new Node('f'), printList);
	};
}