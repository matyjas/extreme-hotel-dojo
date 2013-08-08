import com.google.common.base.Optional;
import com.google.common.collect.Lists;

import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.google.common.collect.Lists.newArrayList;

public class ExtremeStartup extends HttpServlet {

    private static final List<Solver> solverChain = Lists.<Solver>newArrayList(new AddSolver(), 
    			new LargestNumberSolver(), 
    			new MultiplySolver(),
    			new BondMovieSolver(),
    			new CitySolver(),
    			new PMSolver());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getParameter("q"));
        resp.getWriter().write(answer(req.getParameter("q")));
    }

    String answer(String question) {
        if (question == null)
            return "team name";
        for (Solver solver : solverChain) {
            Optional<String> answerOptional = solver.answerTo(question);
            if (answerOptional.isPresent()) {
                String answer = answerOptional.get();
                System.out.println("Got the answer " + answer);
                return answer;
            }
        }
        return "team name";
    }

}
