<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Edit Course</title>
</head>
<body>
<%-- <c:if test="${user == null}">
<c:redirect url="Login"/>
</c:if> --%>
<a href="Logout">Log out</a> 

<form action='EditCourse?id=${edit.id}' method='post'>
<table border=1 ><tbody>
<tr><td> Code:</td><td><input size='40' name='course_no' value= '${edit.course_no}'/></td></tr>
<tr><td> Title:</td><td><input size='40' name='course_name' value='${edit.course_name}'/></td></tr>
<tr>
<td style='vertical-align: top;'> Prerequisite(s): </td><td>
	<c:forEach items = "${entries}" var = "entry">
	<c:if test="${ edit.course_no != entry.course_no}">
		<c:choose>
			<c:when test="${fn:containsIgnoreCase(edits, entry.course_no)}">
				<input type = 'checkbox' name="course_pre" value='${entry.course_no}' checked /> ${entry.course_no}</br>
			 </c:when>
			
			<c:otherwise>
			
			<input name= "course_pre" value='${entry.course_no}' type = 'checkbox' unchecked/> ${entry.course_no} <br>
		
			</c:otherwise>
			</c:choose> 
			</c:if>
			</c:forEach>
	</td>
	</tr>
	</tbody>

</table>
<input type='submit' name='save' value='Save' />
</form>

</body>
</html>