<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit User Profile</title>
</head>
<body>
<div align="center">
<h3>Edit User profile</h3>
</div>
<div align = "center">
<table border = "1">
<tr><td> User Name &nbsp;</td><td>Edit Profile</td></tr>
<c:forEach items = "${l}" var ="user">
<tr><td><c:out value= "${user}" /></td>


<td>
<form action = "PopulateEditUserController" method = "post">
<input type ="hidden" name = "userName" value = "${user}">
<button type = "submit" name = "BtnEdit">Edit User Profile</button>
</form>
</td></tr>
</c:forEach>
</table>


</div>
</body>
</html>