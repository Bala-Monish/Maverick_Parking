<<<<<<< HEAD
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Home</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
</head>
<body>
<form action ="LogoutController" method="post">
<button type='submit' style="position:fixed;right:10px;top:5px;"name="btnLogout">Logout</button>
</form>
<h1 align="center">Maverick Parking</h1>
<h2 align ="center">Admin Home Page</h2>
<div align = "center">
<a href="adminSearch.jsp">Search for a User</a><br>
<a href="changeRole.jsp">Change User Role</a><br>
<a href = "ActivateUserController">Change User Account Status</a><br>
<a href = "SelectUserProfileForEditController">Edit User Profile</a>
<a href="createProfile.jsp">Create Profile</a>
</div>
</body>
=======
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Home</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
</head>
<body>
<form action="LogoutController" method="post">
<button type="submit" style="position:fixed;right:10px;top:5px" name="btnLogout">Logout</button>
</form>
<h1 align="center">Maverick Parking</h1>
<h2 align ="center">Admin Home Page</h2>
<a href=adminSearch.jsp>Search for a User</a><br>
<a href>Change User Role</a><br>
<a href>Change User Account Status</a><br>
</body>
>>>>>>> 33b67b3d4164e7ba319bd54766d6748fb733209b
</html>