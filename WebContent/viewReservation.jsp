<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reservation Details</title>
</head>
<body>
<div>
<h1>Reservation  details  </h1>
</div>
<form action ="LogoutController" method="post">
<button type='submit' style="position:fixed;right:10px;top:5px;"name="btnLogout">Logout</button>
</form>
<table>
<tr>
<c:forEach items = "${res_det}" var ="user">
<td>Reservation ID :<c:out value= "${user.reservationId}" /></td></tr>
<tr><td>Spot ID: <c:out value = "${user.spotId} "/></td></tr>
<tr><td>Duration: <c:out value= "${user.duration}" /></td></tr>
<tr><td>Start Time: <c:out value = "${user.startTime} "/></td></tr>
<tr><td>End Time: <c:out value= "${user.endTime}" /></td></tr>
<tr><td>Camera: <c:out value = "${user.camera} "/></td></tr>
<tr><td>History:<c:out value = "${user.history} "/></td></tr>
<tr><td>Cart:<c:out value = "${user.cart} "/></td></tr>
<tr><td>Total Cost:<c:out value = "${user.totalCost} "/></td></tr>
<tr><td><form action = "ModifyReservationController" method ="post"><button name = "btnModify" type = "submit">Modify Reservation</button><button name = "btnCancel" type = "submit">Cancel Reservation</button>
<input type = "hidden" name = "reservationID" value = "<c:out value= '${user.reservationId}'/>">
<input type = "hidden" name = "spotID" value = "<c:out value = '${user.spotId}'/>">
<input type = "hidden" name = "startTime" value = "<c:out value = '${user.startTime}'/>">
<input type = "hidden" name = "camera" value = "<c:out value = '${user.camera}'/>">
<input type = "hidden" name = "cart" value = "<c:out value = '${user.cart}'/>">
<input type = "hidden" name = "history" value = "<c:out value = '${user.history}'/>">
</form></td></tr>
</c:forEach>
</table>
</body>
</html>