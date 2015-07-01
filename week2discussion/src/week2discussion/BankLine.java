package week2discussion;

import asg.cliche.Command;
import asg.cliche.ShellFactory;

import java.io.IOException;
import java.util.Scanner;

public class BankLine {

	private static StackImplementation<String> line = new StackImplementation<String>();
	
	@Command(name="AddPerson", abbrev="ap")
	public static String add(String name){
		line.push(name);
		return line.toString();
	}
	
	@Command(name="RemovePerson", abbrev="rm")
	public String remove(){
		try {
			return line.pop() + " was removed from line";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return "The line is empty";
		}
	}
	
	@Command(name="CheckPosition", abbrev="cp")
	public String check(int index){
		try {
			return line.get(index);
		} catch (Exception e) {
			return "Not a valid line number\n" + line.toString();
		}
	}
	
	@Command(name="ReplacePerson", abbrev="r")
	public String replace(int index, String person){
		try {
			line.set(index, person);
		} catch (Exception e) {
			return "Not a valid line number\n";
		}
		return line.toString();
	}
	
	@Command(name="ListLine", abbrev="ls")
	public static String list(){
		return line.toString();
	}
	
	public static void main(String[] args) throws IOException {
		ShellFactory.createConsoleShell("bankline", "", new BankLine()).commandLoop();
	}
}
