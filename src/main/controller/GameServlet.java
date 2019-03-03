package main.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.gamestuff.GameNumber;

/**
 * Servlet implementation class GameServlet
 */
@WebServlet(description = "A servlet to control the guessing game.",
    urlPatterns = { "/doGuess" })
public class GameServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public GameServlet()
    {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request,
        HttpServletResponse response) throws ServletException, IOException
    {
        doPost(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request,
        HttpServletResponse response) throws ServletException, IOException
    {

        // retrieve the data

        // retrieve the guess
        GameNumber guess =
            new GameNumber(Integer.parseInt(request.getParameter("guess")));
        // retrieve min and max
        GameNumber minimum =
            new GameNumber(Integer.parseInt(request.getParameter("minimum")));
        GameNumber maximum =
            new GameNumber(Integer.parseInt(request.getParameter("maximum")));

        // retrieve how many guesses have been made
        GameNumber guessNumber = new GameNumber(
            Integer.parseInt(request.getParameter("guessNumber")));

        // retrieve the target value
        GameNumber target =
            new GameNumber(Integer.parseInt(request.getParameter("target")));

        // url for response component
        String url = "";
        
        // process the data
        String message = "";
        if (guess.getValue() == target.getValue())
        {
            message = "Congratulations! You got it right in "
                + guessNumber.getValue() + " guesses!";
            
            url="/correct.jsp";
        }
        else
        {
            guessNumber.increment();
            url="/guess.jsp";
            
            if (guess.getValue() < target.getValue())
            {
                message = "Too low - guess higher.";
            }
            else
            {
                message = "Too high - guess lower.";
            }
            
            // pass the guessNumber object along with the request object
            request.setAttribute("guessNumber", guessNumber);
            
        }
        
        // pass the message along with the request object
        request.setAttribute("message", message);
        
        // pass control to destination URL
        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
        dispatcher.forward(request, response);

        
        /*
        // generate the view
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println(
            "<!DOCTYPE html PUBLIC '-//W3C//DTD HTML 4.01 Transitional//EN' 'http://www.w3.org/TR/html4/loose.dtd'>");
        out.println("<html>");
        out.println("<head>");
        out.println(
            "<meta http-equiv='Content-Type' content='text/html; charset=ISO-8859-1'>");
        out.println("<title>Guessing Game</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Welcome to the Guessing Game</h1>");

        out.println("<p>");
        out.println(message);
        out.println("</p>");

        if (guess.getValue() == target.getValue())
        {
            out.println("<a href='index.jsp'>Play Again</a>");
        }
        else
        {

            out.println(
                "<form name='gameForm' id='gameForm' action='doGuess' method='post'>");
            out.println("<p>");
            out.println("Guess # " + guessNumber.getValue() + ":");
            out.println("<input type='text' name='guess' id='guess'/>");
            out.println("</p>");

            out.println(
                "<input type='submit' name='submit' id='submit' value='Go!' />");

            out.println(
                "<input type='hidden' name='minimum' value=" + minimum.getValue() + " />");
            out.println(
                "<input type='hidden' name='maximum' value=" + maximum.getValue() + " />");
            out.println(
                "<input type='hidden' name='target' value=" + target.getValue() + " />");
            out.println(
                "<input type='hidden' name='guessNumber' value=" + guessNumber.getValue() + " />");

            out.println("</form>");

        }

        out.println("</body>");
        out.println("</html>");
        */

    }

}
