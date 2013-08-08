// which of the following numbers is both a square and a cube: 262144, 922

import com.google.common.base.Optional;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.lang.Math;

public class SquareCubeSolver implements Solver {

    static final Pattern PATTERN = Pattern.compile(".*which of the following numbers is both a square and a cube: ([\\d,\\s]+)");

    @Override
    public Optional<String> answerTo(String question) {

	Matcher squareCubeMatcher = PATTERN.matcher(question);

	if (squareCubeMatcher.matches()) {

            String numbersString = squareCubeMatcher.group(1);
            String[] splitNumberStrs = numbersString.split(",\\s");
	    
	    for (String splitNumberStr : splitNumberStrs) {
		
		int queryNum = Integer.valueOf(splitNumberStr);
		double sqrtOfQuery = Math.sqrt(queryNum);

		if (sqrtOfQuery == (int)sqrtOfQuery){

		    return Optional.of(String.valueOf(sqrtOfQuery));
		}
	    }
	}

	return Optional.absent();
    }
}