import com.google.common.base.Optional;

import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LargestNumberSolver implements Solver {

    public static final Pattern PATTERN = Pattern.compile(".*which of the following numbers is the largest: ([\\d,\\s]+)");

    @Override
    public Optional<String> answerTo(String question) {
        Matcher additionMatcher = PATTERN.matcher(question);
        if (additionMatcher.matches()) {
            String numbersString = additionMatcher.group(1);
            String[] splitNumberStrs = numbersString.split(",\\s");
            Integer max = Integer.MIN_VALUE;
            for (String splitNumberStr : splitNumberStrs) {
                max = Math.max(Integer.valueOf(splitNumberStr), max);
            }

            return Optional.of(String.valueOf(max));
        }
        return Optional.absent();
    }
}
