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
public class MultiplySolver implements Solver {

    @Override
    public Optional<String> answerTo(String question) {
        Matcher additionMatcher = Pattern.compile(".*what is (\\d+) multiplied by (\\d+)").matcher(question);
        if (additionMatcher.matches()) {
            return Optional.of(String.valueOf(Integer.parseInt(additionMatcher.group(1))
                    * Integer.parseInt(additionMatcher.group(2))));
        }
        return Optional.absent();
    }
}
