package hw1;

public class Series {

	public static void main(String[] args) {
		System.out.println(seriesIter(3));
		System.out.println(seriesRec(3));
	}
	
	public static double seriesIter(int ithDigit){
		double iterativeAnswer = 0.0;
		for(int iteration=1; iteration<=ithDigit; iteration++){
			iterativeAnswer += 1/(Math.pow(iteration, 2));
		}
		return iterativeAnswer;
	}
	
	public static double seriesRec(int ithDigit){
		if(ithDigit==1){
			return 1.0;
		}else{
			return seriesRec(ithDigit - 1) + 1/(Math.pow(ithDigit,2));
		}
	}
}
