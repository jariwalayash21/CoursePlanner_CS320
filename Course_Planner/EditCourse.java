package cs320.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs320.model.CourseEntry;


@WebServlet("/EditCourse")
public class EditCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public EditCourse() 
    {
        super();
        
    }
    @SuppressWarnings({ "unchecked", "unused" })
    private CourseEntry getEntry( Integer id )
    {
        List<CourseEntry> entries = (List<CourseEntry>) getServletContext().getAttribute(
            "entries" );

        for( CourseEntry entry : entries )
            if( entry.getId().equals( id ) )
            	return entry;

        return null;
    }


	@SuppressWarnings({ })
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		if(request.getSession().getAttribute("user") == null)
		{
			response.sendRedirect("Login");
			return;
		}
      Integer id = Integer.valueOf( request.getParameter( "id" ) );
      
        request.setAttribute( "edit", getEntryFromDB( id ) );
       
        String str = "";
        
        if(getEntryFromDB( id ).getCourse_pre() != null)
        for(int i = 0; i < getEntryFromDB( id ).getCourse_pre().length; i++)
        {
        	str = str+getEntryFromDB( id ).getCourse_pre()[i];
        }
        request.setAttribute( "edits", str );
       request.getRequestDispatcher( "/WEB-INF/EditCourse.jsp" ).forward(request, response );
		
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
        Integer id = Integer.valueOf( request.getParameter( "id" ) );
        String course_no = request.getParameter("course_no");
		String course_name = request.getParameter("course_name");
        String course_pre[] = request.getParameterValues("course_pre");
        String arr = "";
		
        
        //String arr = " ";
		if(course_pre == null)
		{
			arr = "";
		}
		else
		{
			for(String a: course_pre)
			{
				arr=arr+" "+a;
			}
			
		}

        
        
        
        
        
        
        
        /*if(course_pre!=null)
		{
	         for(String a: course_pre)
	            {
		             arr=arr+" "+a;
	             }
		}*/
        
         try
	        {
			    String url = "jdbc:mysql://cs3.calstatela.edu/cs320stu75";
	            String username = "cs320stu75";
	            String password = "*U5O*L.C";

	            Connection c = DriverManager.getConnection( url, username, password );
	            String sql = "update courses set course_no = ?, course_name = ?, course_pre= ? where id = ?";
	            PreparedStatement pstmt = c.prepareStatement( sql );
	            pstmt.setString( 1, course_no );
	            pstmt.setString( 2, course_name );
	            pstmt.setString(3,arr);
	            pstmt.setInt( 4, id );
	            pstmt.executeUpdate();

	            c.close();
	        }
	        catch( SQLException e )
	        {
	            throw new ServletException( e );
	        }

	      response.sendRedirect("CourseBook");
	}

	
	CourseEntry getEntryFromDB( int id ) throws ServletException
	{
		CourseEntry entry = null; 
		 try
	        {
			    String url = "jdbc:mysql://cs3.calstatela.edu/cs320stu75";
	            String username = "cs320stu75";
	            String password = "*U5O*L.C";

	            Connection c = DriverManager.getConnection( url, username, password );
	            String sql = "select * from courses where id = ?";
	            PreparedStatement pstmt = c.prepareStatement( sql );
	            pstmt.setInt( 1, id );
	            ResultSet rs = pstmt.executeQuery();
	            
	            if( rs.next() )
	            {
	                entry = new CourseEntry();
	                entry.setId( rs.getInt( "id" ) );
	                entry.setCourse_no( rs.getString( "course_no" ) );
	                entry.setCourse_name( rs.getString( "course_name" ) );
	               // entry.set(rs.getString("course_pre"));
	                String cc=rs.getString("course_pre");
	                String arr[] = null;
	                
	                if(cc== null)
	                {
	                	arr = null;
	                }
	                else 
	                	
	                for(int i=0;i<cc.length();i++)
	                {
	                	arr=cc.split("\\s+");
	                }
	                
	              /* if(arr.length <1)
	               {
	            	   entry.setCourse_pre(null);
	               }*/
	                
	              
	            //  for(int i=0;i<arr.length;i++)
	            	   
	             // {	
	                entry.setCourse_pre(arr);
	             // }
	               
	            }

	            c.close();
	        }
	        catch( SQLException e )
	        {
	            throw new ServletException( e );
	        }

	        return entry;
	        }
}
