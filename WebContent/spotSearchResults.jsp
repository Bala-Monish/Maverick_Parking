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
<h1>SpotDetails:</h1>
<form action ="LogoutController" method="post">
<button type='submit' style="position:fixed;right:10px;top:5px;"name="btnLogout">Logout</button>
</form>
<table>
<tr>
<c:forEach items="${spotinfo}" var = "spot">
<td>Spot ID: <c:out value= "${spot.spot_id}" /></td></tr>
<tr><td>Parking area name: <c:out value = "${spot.parea_name} "/></td></tr>
<tr><td>Permit Type: <c:out value = "${spot.permit_type} "/></td></tr>
<tr><td>Availability: <c:out value = "${spot.is_available} "/></td></tr>
</c:forEach>
<form action ="SpotAvailabilityController" method="post">
<button type='submit'style="position:fixed;right:10px;bottom:5px;" name="btnChange">Change Availability</button>
</form>
</tr>
</table>
</body>
</html>