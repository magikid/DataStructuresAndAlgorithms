package project1;

public class OutputDriver {

	public static void main(String[] args) {
		/* 
		 * The SecurityLine constructor with no arguments creates a
		 * SecurityLine with the Gates needed for this assignment.
		 * I have also written another constructor that will accept
		 * an array of gates for modularity. 
		 */
		SecurityLine securityLine = new SecurityLine();
		for(int timePassed=1; timePassed<11; timePassed++){
			securityLine.tick(timePassed);
		}
	}

}
