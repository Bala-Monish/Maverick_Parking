<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Profile Details</title>
</head>
<body>
<h1>The user details  are</h1>
<form action ="LogoutController" method="post">
<button type='submit' style="position:fixed;right:10px;top:5px;"name="btnLogout">Logout</button>
</form>
<table>
<tr>
<c:forEach items = "${prof_det}" var ="user">
<tr><td>Name: <c:out value = "${user.name} "/></td></tr>
<tr><td>Address: <c:out value= "${user.address}" /></td></tr>
<tr><td>Phone: <c:out value = "${user.phone} "/></td></tr>
<tr><td>UTA ID: <c:out value = "${user.utaId} "/></td></tr>
<tr><td>Car License Number: <c:out value= "${user.carLicense}" /></td></tr>
<tr><td>Credit Card: <c:out value = "${user.creditCard} "/></td></tr>
<tr><td>Parking Permit Type:<c:out value = "${user.permitType} "/></td></tr>
</c:forEach>
</table>
</body>
</html>