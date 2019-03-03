package main.controller;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InitParamsServlet
 */
@WebServlet(
		description = "A simple servlet to initialize parameters.", 
		urlPatterns = { "/InitParamsServlet" }, 
		initParams = { 
				@WebInitParam(name = "message", value = "Hello World", description = "A simple initial parameter."),
                @WebInitParam(name = "number", value = "42", description = "Another simple initial parameter.")
		})
public class InitParamsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	String message = "";
	int number = 0;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InitParamsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		this.message = config.getInitParameter("message");
		this.number = Integer.parseInt(config.getInitParameter("number"));
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
