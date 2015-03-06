package cs320.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import cs320.model.CourseEntry;


@WebServlet("/AddCourse")
public class AddCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       int idSeed =100;
    
    public AddCourse() 
    {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		Connection c = null;
		List<String> prereq = new ArrayList<String>();
		try
        {
			String url = "jdbc:mysql://cs3.calstatela.edu/cs320stu75";
            String username = "cs320stu75";
            String password = "*U5O*L.C";


            c = DriverManager.getConnection( url, username, password );
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "select course_no from courses");
           while(rs.next())
           {
           prereq.add(rs.getString("course_no"));
           request.setAttribute("prereq", prereq);
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
		request.getRequestDispatcher( "/WEB-INF/AddCourse.jsp" ).forward(
	            request, response );

}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String course_no = request.getParameter("course_no");
		String course_name = request.getParameter("course_name");
		String[] course_pre = request.getParameterValues("course_pre");
		String arr = "";
		if(course_pre!=null)
		{
	         for(String a: course_pre)
	            {
		             arr=arr+" "+a;
	             }
		}
		 
		Connection c = null;
	        try
	        {
	        	String url = "jdbc:mysql://cs3.calstatela.edu/cs320stu75";
	            String username = "cs320stu75";
	            String password = "*U5O*L.C";

	            String sql = "insert into courses (course_no, course_name,course_pre) values (?, ?,?)";

	            c = DriverManager.getConnection( url, username, password );
	            PreparedStatement pstmt = c.prepareStatement( sql );
	            pstmt.setString( 1, course_no );
	            pstmt.setString( 2, course_name );
	            pstmt.setString( 3, arr );
	            pstmt.executeUpdate();
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

	        // send the user back to the guest book page
	        response.sendRedirect( "CourseBook" );
		}
}
