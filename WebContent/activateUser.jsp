<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Change Account Status</title>
</head>
<body>
<form action ="LogoutController" method="post">
<button type='submit' style="position:fixed;right:10px;top:5px;"name="btnLogout">Logout</button>
</form>
<table border = "1">
<tr><td> User Name &nbsp;</td><td> Name &nbsp;</td> <td>Account Status</td><td>Change </td></tr>
<c:forEach items = "${users}" var ="user">
<tr><td><c:out value= "${user.userName}" /></td>
<td><c:out value = "${user.name} "/></td>
<td><c:out value = "${user.status} "/></td>
<td>
<form action = "ActivateUserController" method = "post">
<input type ="hidden" name = "userName" value = "${user.userName}">
<button type = "submit" name = "modifyBtn">Modify Account Status</button>
</form>
</td></tr>
</c:forEach>
</table>
</body>
</html>