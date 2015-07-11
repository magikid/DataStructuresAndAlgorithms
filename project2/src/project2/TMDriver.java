package project2;

import java.util.Random;

public class TMDriver {
	public static void main(String[] args) {		
		RedBlackTree tree = new RedBlackTree();
		
		// Insert 21 random elements
		for(int i=0; i<21; i++){
			tree.insert(randInt());
		}		
	}
	
	public static int randInt() {
		int min=0, max=100;
	    Random rand = new Random();
	    int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
	}
}
