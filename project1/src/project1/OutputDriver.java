package project1;

public class OutputDriver {

	public static void main(String[] args) {
		SecurityLine securityLine = new SecurityLine();
		for(int timePassed=0; timePassed<10; timePassed++){
			securityLine.tick();
		}
	}

}
