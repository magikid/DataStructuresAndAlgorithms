package hw1;

/**
 * This class provides two functions for calculating  the series 1/(1^2) + 1/(2^2) ... 1/(i^2).
 * @author Chris W Jones
 *
 */
public class Series {
	/**
	 * For calculating the series iteratively
	 * @param ithDigit
	 * @return
	 */
	public static double seriesIter(int ithDigit){
		double iterativeAnswer = 0.0;
		for(int iteration=1; iteration<=ithDigit; iteration++){
			iterativeAnswer += 1/(Math.pow(iteration, 2));
		}
		return iterativeAnswer;
	}
	
	/**
	 * For calculating the series recursively
	 * @param ithDigit
	 * @return
	 */
	public static double seriesRec(int ithDigit){
		if(ithDigit==1){
			return 1.0;
		}else{
			return seriesRec(ithDigit - 1) + 1/(Math.pow(ithDigit,2));
		}
	}
}
