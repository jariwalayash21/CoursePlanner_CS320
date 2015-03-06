<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>



<c:if test="${user == null}">
<c:redirect url="Login"/>
</c:if>
<a href="Logout">Log out</a>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Add Course</title>
</head>
<body>


 

<form action='AddCourse' method= 'post'>
<table border=1 >
<tr><td> Code:</td><td><input type = 'text' name='course_no'/></td></tr>
<tr><td> Title:</td><td><input type = 'text' name='course_name'/></td></tr>
<tr><td>Prerequisite(s):</td>
<td>
<c:forEach items="${prereq}" var="entry">
<input name='course_pre' value="${entry}" type='checkbox'>${entry}</input><br>
</c:forEach>
</td></tr>
			
		<tr><td>
       <input type='submit' name='add' value='Add' /> <br />
		</td></tr>

	</table>	
	</form>
</body>
</html>