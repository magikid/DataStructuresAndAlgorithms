package project1;

import java.util.Arrays;
import java.util.Collections;

public class PeopleGenerator {
	
	public static String[] generate(int minute){
        int randPicker = (int)(Math.random()*26);
		char c = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray()[randPicker];
		String[] people = new String[] {
				"John " + c, 
				"James " + c,
				"Steve " + c,
				"Paul " + c,
				"Mary " + c,
				"Janice " + c,
				"Liz " + c,
				"Hilary " + c,
				"Chris " + c,
				"Carol " + c
			}; 
		
		Collections.shuffle(Arrays.asList(people));
		return people;
	}
}
