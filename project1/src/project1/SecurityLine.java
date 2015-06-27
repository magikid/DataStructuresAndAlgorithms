package project1;

import java.util.ArrayDeque;
import java.util.Arrays;

public class SecurityLine {
	private ArrayDeque<String> lineOfPeople;
	private Gate[] gates;
	private int time;
	
	public SecurityLine(){
		lineOfPeople = new ArrayDeque<String>();
		gates = new Gate[]{
				new Gate(1),
				new Gate(2),
				new Gate(2),
				new Gate(3),
				new Gate(3)
		};
		time = 0;
		
		addTenPeople();
		addTenPeople();
	}
	
	public SecurityLine(Gate[] createdGates){
		lineOfPeople = new ArrayDeque<String>();
		gates = createdGates;
		time = 0;
		
		addTenPeople();
		addTenPeople();
	}
	
	public void tick(){
		time++;
		outputBeginning();
		addTenPeople();
		clearAllGates();
		Gate nextGate = checkForFreeGate();
		while (nextGate != null) {
			nextGate.sendToGate(lineOfPeople.removeFirst());
			nextGate = checkForFreeGate();
		}
		outputEnding();
	}
	
	private String peopleInLine(){
		return Arrays.toString(lineOfPeople.toArray()) + "\n";
	}
	
	private void clearAllGates(){
		for(Gate gate: gates){
			gate.clearGate();
		}
	}
	
	private Gate checkForFreeGate(){
		for(Gate gate: gates){
			if(gate.free()){
				return gate;
			}
		}
		return null;
	}
	
	public void outputBeginning(){
		StringBuilder output = new StringBuilder();
		output.append("Beginning of minute " + time + "\n");
		outputSummary(output);
	}
	
	public void outputEnding(){
		StringBuilder output = new StringBuilder();
		output.append("End of minute " + time + "\n");
		outputSummary(output);
		System.out.println("******************************************\n");
	}
	
	private void outputSummary(StringBuilder output){
		output.append("========================\n");
		output.append("The gates processed:\n");
		for(int k=0; k<gates.length; k++){
			Gate gate = gates[k];
			output.append("\tGate" + (k + 1) + ": ");
			output.append(gate.peopleProcessedByGate());	
		}
		output.append("\n");
		output.append("People in line: ");
		output.append(peopleInLine());
		output.append("Number of people in line: " + lineOfPeople.size() + "\n\n");
		System.out.print(output.toString());
	}
	
	private void addTenPeople(){
		for (String person : PeopleGenerator.generate(time)) {
			lineOfPeople.addLast(person);
		}
	}
}
