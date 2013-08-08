import com.google.common.base.Optional;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: naznauryan
 * Date: 08/08/2013
 * Time: 18:12
 * To change this template use File | Settings | File Templates.
 */
public class PMSolver implements Solver {

    public static final Pattern PATTERN = Pattern.compile(".*who is the Prime Minister of Great Britain");
    
    public static final String DAVID_CAMERON = "David Cameron";

    @Override
    public Optional<String> answerTo(String question) {
        Matcher movieMatcher = PATTERN.matcher(question);
        if (movieMatcher.matches()) {
            return Optional.of(DAVID_CAMERON);
        }
        return Optional.absent();
    }
}
