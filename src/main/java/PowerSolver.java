// what is 0 to the power of 3

import com.google.common.base.Optional;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.lang.Math;

public class PowerSolver implements Solver {

    static final Pattern POWER_PATTERN = Pattern.compile(".*what is (\\d+) to the power of (\\d+)");

    @Override
    public Optional<String> answerTo(final String question) {

	Matcher mtchr = POWER_PATTERN.matcher(question);
	if(mtchr.matches()) {

	    return Optional.of(String.valueOf(Math.pow(Integer.parseInt(mtchr.group(1)), 
						       Integer.parseInt(mtchr.group(2)))));
	}
	return Optional.absent();
    }
}