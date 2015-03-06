<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Course Planner</title>
</head>
<body>
<br/><br/>





<b>You may take the following courses in <u>${qatr}</u></b> 
<form action="NextQuarter" method="post">
<input type="hidden" name="qtr" value="${qatr }"/>
<table border =1>
<tr><th>     </th><th>Code</th><th>Title</th><th>Prerequisites</th></tr>

<c:forEach items="${coursesThisQ}" var="entry">
<tr><td><input type = "checkbox" name ="courses" value = "${entry.course_no}"/> </td><td>${entry.course_no }</td><td>${entry.course_name }</td>
<td><c:forEach items = "${entry.course_pre }" var="pre">${pre} </c:forEach></td></tr>
</c:forEach>


</table><input type='submit' name='button' value='Next' /> 
<input type='submit' name='button' value='Finish' /> <br />

<!--  <a href= "PlannedCourse">Planned course</a>-->

</form>




</body>
</html>