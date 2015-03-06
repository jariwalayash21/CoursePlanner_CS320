package cs320.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import cs320.model.UserEntry;


@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	boolean torf= false;
   
	
	public Login() 
	{
        super();
       
    }
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
			
		request.getRequestDispatcher( "/WEB-INF/Login.jsp" ).forward(request, response );
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String username = request.getParameter("username");
    	String password = request.getParameter("password");
    	
    	
    	  try
          {
    		  String url = "jdbc:mysql://cs3.calstatela.edu/cs320stu75";
	            String username1 = "cs320stu75";
	            String password1 = "*U5O*L.C";

              
              
              Connection c = (Connection) DriverManager.getConnection( url, username1, password1 );
              
              Statement stmt = (Statement) c.createStatement();
              ResultSet rs = stmt.executeQuery( "select * from users where username = '"+ username + "' and password = '" + password + "'" );

              while( rs.next() )
              {
                  String uname1 = rs.getString( "username" );
                  String pass1 = rs.getString( "password" );
   
         
               
                  
                  if(username.equals(uname1) && password.equals(pass1))
                  {  
                	 
                	  request.getSession().setAttribute( "user", username );
                	  response.sendRedirect( "CourseBook" );
                  }  
                  else
                   {  
                        	  
                        	  response.sendRedirect( "Login" );
                    }  
              
              }
              
              c.close();
          }
          catch( SQLException e )
          {
              throw new ServletException( e );
          }
          
    }
		
}


	



