// which of the following numbers is both a square and a cube: 262144, 922

import com.google.common.base.Optional;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.lang.Math;

public class SquareCubeSolver implements Solver {

    static final Pattern PATTERN = Pattern.compile(".*which of the following numbers is both a square and a cube: ([\\d,\\s]+)");

    public static double cubeRoot(double x) {  
	return Math.pow(x, 1.0/3);  
    }  

    @Override
    public Optional<String> answerTo(String question) {

	Matcher squareCubeMatcher = PATTERN.matcher(question);

	if (squareCubeMatcher.matches()) {

            String numbersString = squareCubeMatcher.group(1);
            String[] splitNumberStrs = numbersString.split(",\\s");
	    
	    for (String splitNumberStr : splitNumberStrs) {
		
		int queryNum = Integer.valueOf(splitNumberStr);
		double sqrtOfQuery = Math.sqrt(queryNum);
		double cubeRootOfQuery = cubeRoot(queryNum);


		if ((sqrtOfQuery == (int)sqrtOfQuery) && (cubeRootOfQuery == (int)cubeRootOfQuery)) {

		    return Optional.of(String.valueOf(queryNum));
		}
	    }
	}

	return Optional.absent();
    }
}