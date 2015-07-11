package project2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class TMDriver {
	public static void main(String[] args) {
		RedBlackTree<Integer> tree = new RedBlackTree<Integer>();
		List<Integer> nums = new ArrayList<Integer>();
		StringBuilder finalOutput = new StringBuilder();
		
		// Insert 21 random elements
		nums.add(randInt());
		finalOutput.append("Initial numbers added to tree: [ ");
		for(int i=0; i<20; i++){
			int randomNumber = randInt();
			while(nums.contains(randomNumber)){
				randomNumber = randInt();
			}
			nums.add(randomNumber);
			finalOutput.append(nums.get(i) + " ");
		}
		finalOutput.append("]\n\n");
			
		
		
		for (int i : nums) {
			tree.insert(i);
		}
		
		// Functions for homework
		finalOutput.append("Inorder print\n");
		finalOutput.append("=============\n");
		finalOutput.append(tree.printTree("order") + "\n\n");
		
		finalOutput.append("Searches\n");
		finalOutput.append("========\n");
		finalOutput.append("Finding number in tree: " + nums.get(1) + "\n");
		if(tree.search(nums.get(1)).key == nums.get(1)){
			finalOutput.append("Found it! got: " + nums.get(1) + "\n");
		}
		
		finalOutput.append("Finding number not in tree: 999\n");
		if(tree.search(999)==null){
			finalOutput.append("Not found, null returned\n\n");
		}
		
		finalOutput.append("Stats\n");
		finalOutput.append("======\n");
		finalOutput.append("Height: " + tree.height() + "\n");
		finalOutput.append("Number leaves: " + tree.leaves().size() + "\n");
		finalOutput.append("Number internal nodes: " + tree.numInternalNodes() + "\n\n");
		finalOutput.append("Inserting\n");
		finalOutput.append("=========\n");
		finalOutput.append("new RedBlackNode(key=101)\n");
		tree.insert(101);
		finalOutput.append(tree.printTree() + "\n");
		finalOutput.append("New Height: " + tree.height() + "\n\n");
		
		finalOutput.append("Different traversals\n");
		finalOutput.append("====================\n");
		finalOutput.append("In order: " + tree.printTree("order") + "\n");
		finalOutput.append("Preorder: " + tree.printTree("pre") + "\n");
		finalOutput.append("Postorder: " + tree.printTree("post") + "\n");
		finalOutput.append("New number leaves: " + tree.leaves().size() + "\n");
		finalOutput.append("Number internal nodes: " + tree.numInternalNodes() + "\n\n");
		System.out.println(finalOutput.toString());
	}
	
	public static int randInt() {
		int min=0, max=100;
	    Random rand = new Random();
	    int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
	}
}
