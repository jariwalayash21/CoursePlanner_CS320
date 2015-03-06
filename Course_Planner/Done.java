package cs320.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs320.model.Quarter;

/**
 * Servlet implementation class Done
 */
@WebServlet("/Done")
public class Done extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Done() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		getServletContext().removeAttribute("coursesThisQ");
		getServletContext().removeAttribute("finall");
		//getServletContext().removeAttribute("q");
		getServletContext().removeAttribute("quarters");
		List<Quarter> q=(List<Quarter>)getServletContext().getAttribute("q");
		q.clear();
		getServletContext().removeAttribute("coursesTaken");
		response.sendRedirect("CourseBook");
		return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
