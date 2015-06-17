package hw1;

public class TestSeriesVal {

	public static void main(String[] args) {
		double manSol, iterSol, recSol = 0.0;
        
		manSol = 1.0+1.0/4+1.0/9+1.0/16+1.0/25+1.0/36+1.0/49;
		iterSol = Series.seriesIter(7);
		recSol = Series.seriesRec(7);
		
		System.out.println("Manual solution");
		System.out.println(manSol);
		
		System.out.println("Iterative solution");
		System.out.println(iterSol);
		
		System.out.println("Recursive solution");
		System.out.println(recSol);
		
		System.out.println("Matching responses?");
		System.out.println(manSol == iterSol && manSol == recSol);
	}

}
