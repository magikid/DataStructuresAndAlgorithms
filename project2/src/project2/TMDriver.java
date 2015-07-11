package project2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class TMDriver {
	public static void main(String[] args) {
		RedBlackTree tree = new RedBlackTree();
		List<Integer> nums = new ArrayList<Integer>();
		
		// Insert 21 random elements
		nums.add(randInt());
		for(int i=0; i<20; i++){
			int randomNumber = randInt();
			while(nums.contains(randomNumber)){
				randomNumber = randInt();
			}
			nums.add(randomNumber);
			System.out.println("nums[" + i + "]=" + nums.get(i));
		}
			
		
		
		for (int i : nums) {
			tree.insert(i);
		}
		
		// Assignment functions
		System.out.println("\nInorder print");
		System.out.println("=============");
		tree.printTree();
		System.out.println("\nSearches");
		System.out.println("========");
		System.out.println("Finding number in tree: " + nums.get(1));
		if(tree.find(nums.get(1)) == nums.get(1)){
			System.out.println("Found it! got: " + nums.get(1));
		}
		
		System.out.println("Finding number not in tree: 999");
		if(tree.find(999)==null){
			System.out.println("Not found, null returned");
		}
		
		System.out.println("\nHeight");
		System.out.println("======");
		System.out.println(tree.height());
	}
	
	public static int randInt() {
		int min=0, max=100;
	    Random rand = new Random();
	    int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
	}
}
