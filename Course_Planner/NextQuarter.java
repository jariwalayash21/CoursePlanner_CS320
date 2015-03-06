package cs320.servlet;
import java.util.Calendar;

import java.awt.Button;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs320.model.CourseEntry;
import cs320.model.Quarter;
import cs320.model.UserEntry;


@SuppressWarnings("unused")
@WebServlet(urlPatterns = "/NextQuarter",loadOnStartup = 1)
public class NextQuarter extends HttpServlet
{
	private static final long serialVersionUID = 1L;
       
	int id = 100;
	//int week = Calendar.WEEK_OF_YEAR;
	int year=Calendar.getInstance().get(Calendar.YEAR);
	
    public NextQuarter() 
    {
        super();
       
    }
    List<Quarter> q = new ArrayList<Quarter>();
	
	
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		int week = (int) getServletContext().getAttribute("week");
		int i=(int) getServletContext().getAttribute("counter");
		List<CourseEntry> entries = (List<CourseEntry>) getServletContext().getAttribute("entries");
		
		List<CourseEntry> coursesThis = entries;
		
		List<String> coursesTaken = (List<String>) getServletContext().getAttribute("coursesTaken");
		
		List<CourseEntry> coursesThisQQ = coursesThisQuarter(coursesThis, coursesTaken);
		List<String> qt= new ArrayList<String>();
		if(week>=1 && week <=12)
		{
			//Quarter winter=new Quarter("Spring "+year);
			//q.add(winter);
			qt.add("Spring "+(year+i));
			System.out.println(week);
			week += 12;
			getServletContext().setAttribute("week", week);
		}
		else if(week>=13 && week<=24)
		{
			//Quarter winter=new Quarter("Summer "+year );
			//q.add(winter);
			qt.add("Summer "+(year+i));
			System.out.println(week);
			week += 12;
			getServletContext().setAttribute("week", week);
			
		}
		else if(week>=25 && week<=37)
		{
			//Quarter winter=new Quarter("Fall "+year);
			//q.add(winter);
			qt.add("Fall "+(year+i));
			i+=1;
			getServletContext().setAttribute("counter", i);
			System.out.println(week);
			week += 12;
			getServletContext().setAttribute("week", week);
		}
		else
		{
			//Quarter winter=new Quarter("Winter "+year);
			//q.add(winter);
			qt.add("Winter "+(year+i));
			System.out.println(week);
			week=Calendar.WEEK_OF_YEAR;
			getServletContext().setAttribute("week", week);
		}
		getServletContext().setAttribute("qatr", qt);
		request.getServletContext().setAttribute("coursesThisQ", coursesThisQQ);
		 request.getRequestDispatcher( "/WEB-INF/NextQuarter.jsp" ).forward(
		            request, response );
	}
		
	@SuppressWarnings({ "unchecked" })
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		List<CourseEntry> ent = new ArrayList<CourseEntry>();
		String[] courses = request.getParameterValues("courses");
		String button =request.getParameter("button");
		String qtr=request.getParameter("qtr");
		  List<CourseEntry> finall=new ArrayList<CourseEntry>();
		  		
		List<CourseEntry> entries = (List<CourseEntry>) getServletContext().getAttribute("entries");
		
		List<String> coursesTaken = (List<String>) getServletContext().getAttribute("coursesTaken");
		
		if(courses == null) ///Check this
		{
			System.out.println("hello");
			coursesTaken.add("");
			
		}
		else
		
		
		for(String course : courses)
		{
			
			for(CourseEntry cours : entries)
			{
				
				if(course.equalsIgnoreCase(cours.getCourse_no()))
				{
					ent.add(cours);
					finall.add(cours);
					
				}
				else
				{
					System.out.println("hello");
					
				}
			}
			coursesTaken.add(course);
		}
		
		
		
		//Quarter winter=new Quarter("Spring",finall);
		List<CourseEntry> coursesThisQQ = (List<CourseEntry>) getServletContext().getAttribute("coursesThisQ");
		q.add(new Quarter(qtr,finall));
		
		request.getServletContext().setAttribute("finall", finall);
		request.getServletContext().setAttribute("q", q);
		if(button.equalsIgnoreCase("Next"))
		{
			response.sendRedirect("NextQuarter");
		}
		if(button.equalsIgnoreCase("Finish"))
		response.sendRedirect("PlannedCourse");
	
	}	
	
	
	
	
	List<CourseEntry> coursesThisQuarter(List<CourseEntry> coursesThis, List<String> coursesTaken)
	{
		List<CourseEntry> coursesThisQ = new ArrayList<CourseEntry>();
		
		for(CourseEntry course : coursesThis)
		{
			if(course.getCourse_pre() == null)
			{
				int i = 0;
				for(String cours: coursesTaken)
				{
					if(cours.equalsIgnoreCase(course.getCourse_no()))
					{
						i++;
					}
				}
				if(i == 0)
				{
					coursesThisQ.add(course);
				}
			}
			else
			{
				boolean eligible = false;
				int count = 0;
				for(String cours: course.getCourse_pre())
				{
					if(coursesTaken.contains(cours))
					{
						count++;
					}
				}
				if(count == course.getCourse_pre().length)
				{
					eligible = true;
				}
				
				if(eligible)
				{
					coursesThisQ.add(course);
				}
			}
		}
		
		List<CourseEntry> repeated = new ArrayList<CourseEntry>();

		for(String course:coursesTaken)
		{
		if(coursesThisQ!=null)
		for(CourseEntry cours : coursesThisQ)
		{
				if(course.equalsIgnoreCase(cours.getCourse_no()))
				{
					repeated.add(cours);
				}
			}
		}
		
		
		for(int i = 0; i < repeated.size(); i++)
		{
			coursesThisQ.remove(repeated.get(i));
		}
		
		return coursesThisQ;
		
	}
}