import com.google.common.base.Optional;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Created with IntelliJ IDEA.
 * User: halazar
 * Date: 8/8/13
 * Time: 7:05 PM
 * To change this template use File | Settings | File Templates.
 */
public class SubtractSolver implements Solver {
    static final Pattern PATTERN = Pattern.compile(".*what is (\\d+) minus (\\d+)");

    @Override
    public Optional<String> answerTo(String question) {

        Matcher subtractionMatcher = PATTERN.matcher(question);

        if (subtractionMatcher.matches()) {
            return Optional.of(String.valueOf(Integer.parseInt(subtractionMatcher.group(1))
                    - Integer.parseInt(subtractionMatcher.group(2))));
        }
        return Optional.absent();
    }
}