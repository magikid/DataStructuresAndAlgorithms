package project1;

import java.util.ArrayDeque;
import java.util.Arrays;

public class Gate {
	private int rate;
	private ArrayDeque<String> processedByGate;
	
	public Gate(int setRate){
		rate = setRate;
		processedByGate = new ArrayDeque<String>();
	}
	
	public Boolean free(){
		if(processedByGate.size() < rate){
			return true;
		}else{
			return false;
		}
	}
	
	public void sendToGate(String personName){
		processedByGate.addLast(personName);
	}
	
	public void clearGate(){
		processedByGate.clear();
	}
	
	public String peopleProcessedByGate(){
		return Arrays.toString(processedByGate.toArray()) + "\n";
	}
}
