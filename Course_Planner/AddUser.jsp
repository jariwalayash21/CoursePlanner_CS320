<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Add User</title>
</head>
<body>
<html><head><title>User Registration</title></head><body>
<form action='AddUser' method= 'post'>
<table border=1 >
<h2>Add new User</h2>
<tr><td> Username:</td><td><input type = 'text' name='username'/></td></tr>
<tr><td> Password:</td><td><input type = 'password' name='password'/></td></tr>
<tr><td> Re-type password:</td><td><input type = 'password' name='re_password'/></td></tr>
<tr><td> First Name (optional):</td><td><input type = 'text' name='fname'/></td></tr>
<tr><td> Last Name (optional):</td><td><input type = 'text' name='lname'/></td></tr></table>
<input type='submit' name='add' value='Register' /> <br />
</form>
</body>
</html>