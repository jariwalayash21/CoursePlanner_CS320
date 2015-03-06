<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Course Directory</title>
</head>
<body>
<c:if test="${not empty user}">
<a href="Logout">Logout</a>
</c:if>
<c:if test="${user == null}">
<a href="Login">Login</a>
</c:if>


<h2> Course Directory for CS</h2>
<table border =1>
<tr><th>Code</th><th>Title</th><th>Prerequisites</th><th>Operation</th></tr>

<c:forEach items="${entries}" var="entry">
<td>${entry.course_no }</td><td>${entry.course_name }</td>
<td><c:forEach items = "${entry.course_pre }" var="pre">${pre} </c:forEach></td><td><a href="EditCourse?id=${entry.id} ">Edit</a></td></tr>
</c:forEach>



</table>
<br><a href="AddCourse">Add Course</a>
<br><a href="CoursePlanner">Course Planner</a>

</body>
</html>