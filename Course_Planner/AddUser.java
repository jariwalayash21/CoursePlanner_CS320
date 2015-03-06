package cs320.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



//import cs320.model.UserEntry;


@WebServlet(urlPatterns = "/AddUser",loadOnStartup = 1)
public class AddUser extends HttpServlet
{
	private static final long serialVersionUID = 1L;
       
	int id = 100;
    public AddUser() 
    {
        super();
       
    }

  
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		 request.getRequestDispatcher( "/WEB-INF/AddUser.jsp" ).forward(
		            request, response );
		
	}
		
	@SuppressWarnings({ })
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		
		
		
		PrintWriter out = response.getWriter();
		boolean flag = true;
		
		String username1 = request.getParameter("username");
		String password1 = request.getParameter("password");
		String re_password1 = request.getParameter("re_password");
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		
		
		
		Connection c = null;
        try
        {
        	String url = "jdbc:mysql://cs3.calstatela.edu/cs320stu75";
            String username = "cs320stu75";
            String password = "*U5O*L.C";


            c = DriverManager.getConnection( url, username, password );
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "select * from users where username='"+username1+"'" );

            if(rs.next())
            {
            	flag = false;
    			out.println("<br> ");
    			out.println("Username already exists");
            }
            c.close();
        }
        catch( SQLException e )
        {
            throw new ServletException( e );
        }

		
		if(username1 == "" && password1 == "" && re_password1 =="" )
		{
			out.println("<br> ");
			out.println("Required fields can't be empty");
			flag = false;
			doGet(request, response);
			return;
		}
	
	
		if(username1.length()>=0 && username1.length()<4 && username1!="")
		{
			out.println("<br> ");
			out.println(" Username is shorter than 4 characters. ");
			flag = false;
		}
		
		
		
		if(password1.length()>=0 && password1.length()<4 && password1!="" )
		{
			out.println("<br> ");
			out.println("Password is shorter than 4 characters.");
			flag = false;
		}
		
		 if(username1=="" )
			{
				out.println("<br>");
				out.println("Username can't be empty");
				flag = false;
			}
		
	 if(password1=="" )
		{
			out.println("<br>");
			out.println("Password can't be empty");
			flag = false;
		}
		
		
	 if(!(password1.equals(re_password1)))
		{
			out.println("<br>");
			out.println("Password and re-typed password do not match.");
			flag = false;
		}
		
		
	

	if(flag==true)
	{
		Connection cl = null;
        try
        {
        	String url = "jdbc:mysql://cs3.calstatela.edu/cs320stu75";
            String username = "cs320stu75";
            String password = "*U5O*L.C";

            
            String sql = "insert into users (username,password,re_password,fname,lname) values (?,?,?,?,?)";

            cl = DriverManager.getConnection( url, username, password );
            PreparedStatement pstmt = cl.prepareStatement( sql );
            pstmt.setString( 1, username1 );
            pstmt.setString( 2, password1 );
            pstmt.setString( 3, re_password1);
            pstmt.setString( 4, fname);
            pstmt.setString( 5, lname);
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

        
        response.sendRedirect( "CourseBook" );
	
	}}}
	

		
		
		
		
		
	
	
		



