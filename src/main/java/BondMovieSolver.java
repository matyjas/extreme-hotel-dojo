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
public class BondMovieSolver implements Solver {

    public static final Pattern PATTERN = Pattern.compile(".*who played James Bond in the film Dr No");
    
    public static final String SEAN_CONNERY = "Sean Connery";

    @Override
    public Optional<String> answerTo(String question) {
        Matcher additionMatcher = PATTERN.matcher(question);
        if (additionMatcher.matches()) {
            return Optional.of(SEAN_CONNERY);
        }
        return Optional.absent();
    }
}
