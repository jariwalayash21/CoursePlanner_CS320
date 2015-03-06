<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Your Planned Courses are</title><br>
</head>
<body>
<form action='PlannedCourse' method= 'post'>
Here in your course plan:-
<c:forEach items="${quarters}" var="e">
<table border =1>
<br><u><b>${e.name}</b></u>

<tr><th>Code</th><th>Title</th><th>Prerequisites</th></tr>

<c:forEach items="${e.courses}" var="entry">
<tr>
<td>${entry.course_no }</td><td>${entry.course_name }</td>
<td><c:forEach items = "${entry.course_pre}" var="pre">${pre} </c:forEach></td><br>
</tr>
</c:forEach>
</table><br>
</c:forEach>

<a href="Done">Done</a>
</form>
</body>
</html>