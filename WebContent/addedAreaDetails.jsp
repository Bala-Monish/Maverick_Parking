<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spot Search Results</title>
</head>
<body>
<h1>Area Details:</h1>
<form action ="LogoutController" method="post">
<button type='submit' style="position:fixed;right:10px;top:5px;"name="btnLogout">Logout</button>
</form>
<table>
<tr>
<c:forEach items="${parkinginfo}" var = "park">
<td>Parking Area Name: <c:out value= "${park.parea_name}" /></td></tr>
<tr><td>Parking area name: <c:out value = "${park.floor} "/></td></tr>
<tr><td>Permit Type: <c:out value = "${park.ptype} "/></td></tr>
<tr><td>Capacity: <c:out value = "${park.pcapacity} "/></td></tr>
</c:forEach>

</tr>
</table>
</body>
</html>