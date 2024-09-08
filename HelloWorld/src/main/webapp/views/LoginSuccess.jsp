<%@ page import="ute.controllers.LoginModel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="Index.jsp" method="post">
		<label for="username">UserName:</label> <input type="text"
			id="username" name="username"><br>
		<br> <label for="password">Password:</label> <input type="text"
			id="password" name="password"><br>
		<br> <input type="submit" value="Login">
	</form>
</body>
</html>