package cs320.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import cs320.model.CourseEntry;
//import cs320.model.UserEntry;


@WebServlet("/CourseBook")
public class CourseBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public CourseBook() 
    {
        super();
        
    }

	
	public void init(ServletConfig config) throws ServletException
	{
		
		super.init( config );

        try
        {
            Class.forName( "com.mysql.jdbc.Driver" );
        }
        catch( ClassNotFoundException e )
        {
            throw new ServletException( e );
        }
       
	
}

	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		 
		List<CourseEntry> entries = new ArrayList<CourseEntry>();
        Connection c = null;
        try
        {
        	String url = "jdbc:mysql://cs3.calstatela.edu/cs320stu75";
            String username = "cs320stu75";
            String password = "*U5O*L.C";


            c = DriverManager.getConnection( url, username, password );
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "select * from courses" );

            while( rs.next() )
            {
            	Integer id = rs.getInt("id");
            	String course_no = rs.getString("course_no");
            	String course_name = rs.getString("course_name");
            	String prereq = rs.getString("course_pre");
            	String pre[] = prereq.split("\\s+");
            	
            	entries.add(new CourseEntry(id,course_no,course_name,pre));
            	
            	//CourseEntry entry = new CourseEntry( rs.getInt("id"),rs.getString("course_no"), rs.getString( "course_name" ), rs.getString("course_pre"));
                //entries.add( entry );
            }
            c.close();
        }
        catch( SQLException e )
        {
            throw new ServletException( e );
        }
        finally
        {
            try
            {
                if( c != null ) c.close();
            }
            catch( SQLException e )
            {
                throw new ServletException( e );
            }
        }

        getServletContext().setAttribute("entries", entries);
        request.getRequestDispatcher( "/WEB-INF/CourseBook.jsp" ).forward(
            request, response );
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request,response); 
	}

}
