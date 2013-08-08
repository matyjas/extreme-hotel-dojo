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
public class CitySolver implements Solver {

    public static final Pattern PATTERN = Pattern.compile(".*which city is the Eiffel tower in");
    
    public static final String PARIS = "Paris";

    @Override
    public Optional<String> answerTo(String question) {
        Matcher movieMatcher = PATTERN.matcher(question);
        if (movieMatcher.matches()) {
            return Optional.of(PARIS);
        }
        return Optional.absent();
    }
}
