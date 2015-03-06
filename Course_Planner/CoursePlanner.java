package cs320.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import cs320.model.CourseEntry;
//import cs320.model.Quarter;
//import cs320.model.QuarterPlan;


@WebServlet("/CoursePlanner")
public class CoursePlanner extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CoursePlanner() 
    {
        super();

    }
    
    public void init(ServletConfig config) throws ServletException
	{
		super.init( config );
    	
    }
    
	//@SuppressWarnings("unchecked")

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{	
    	
    	getServletContext().setAttribute("coursesTaken", new ArrayList<String>());
    	request.getRequestDispatcher( "/WEB-INF/CoursePlanner.jsp" ).forward(
	            request, response );
    	
		
	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	
		int i=0;
		 
		String[] courses = request.getParameterValues("courses");
		
		List<String> coursesTaken = (List<String>) getServletContext().getAttribute("coursesTaken");
		getServletContext().setAttribute("counter",i);
		getServletContext().setAttribute("week",Calendar.WEEK_OF_YEAR);
		for(String course : courses)
		{
		//	System.out.println(course);
			coursesTaken.add(course);
		}	
		
		response.sendRedirect("NextQuarter");
	
	}

}
