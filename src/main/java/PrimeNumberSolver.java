import com.google.common.base.Optional;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PrimeNumberSolver implements Solver {

    public static final Pattern PATTERN = Pattern.compile(".*which of the following numbers are primes: ([\\d,\\s]+)");

    @Override
    public Optional<String> answerTo(String question) {
        Matcher additionMatcher = PATTERN.matcher(question);
        if (additionMatcher.matches()) {
            String numbersString = additionMatcher.group(1);
            String[] splitNumberStrs = numbersString.split(",\\s");
            String answer = "";
            for (String splitNumberStr : splitNumberStrs) {
                Integer testNumber = Integer.valueOf(splitNumberStr);
                boolean isPrime = true;
                for (int i = 2; i <= testNumber/2; i++) {
                    if (testNumber % i == 0) {
                        isPrime = false;
                        break;
                    }
                }
                if (isPrime) {
                    answer += testNumber + ", ";
                }
            }

            return Optional.of(String.valueOf(answer.substring(0, answer.length()-2)));
        }
        return Optional.absent();
    }
}
