package cs320.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs320.model.CourseEntry;
import cs320.model.Quarter;


@WebServlet("/PlannedCourse")
public class PlannedCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PlannedCourse() 
    {
        super();
    }

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		//getServletContext().setAttribute("coursesThisQ","coursesThisQ" );
		List<CourseEntry> coursesThisQ =(List<CourseEntry>)getServletContext().getAttribute("coursesThisQ");//
		List<CourseEntry> finall=(List<CourseEntry>)getServletContext().getAttribute("finall");//
		List<Quarter> q=(List<Quarter>)getServletContext().getAttribute("q");//
		getServletContext().setAttribute("coursesThisQ", coursesThisQ);
		getServletContext().setAttribute("finall", finall);
		getServletContext().setAttribute("quarters", q);
		
		
		for(int i=0;i<q.size();i++){
			for(CourseEntry ce: q.get(i).getCourses()){
				System.out.println(ce.getCourse_name());
				System.out.println(ce.getCourse_no());
			}
		}
		request.getRequestDispatcher( "/WEB-INF/PlannedCourse.jsp" ).forward(
	            request, response );
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
	
		
		
		
		
	}

}
