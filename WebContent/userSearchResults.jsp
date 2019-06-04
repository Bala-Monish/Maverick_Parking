<<<<<<< HEAD
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Search Results</title>
</head>
<body>
<h1>The parking spot details  are</h1>
<form action="LogoutController" method="post">
<button type="submit" style="position:fixed;right:10px;top:5px" name="btnLogout">Logout</button>
</form>

<table border="1">
<tr>
<td>Parking Area Name	</td>&nbsp;
<td>Floor 	</td>&nbsp;
<td>Parking Type	</td>&nbsp;
<td>Available Spots </td>
</tr>
<c:forEach items = "${parkdet}" var ="park">
<tr>

<td><input name="parkingAreaName" value="<c:out value='${park.parkingAreaName}'/>" type="text" disabled="disabled"></td>
<td><c:out value = "${park.floor}"/></td>
<td><c:out value= "${park.parkingType}" /></td>
<td><c:out value = "${park.pcapacity}"/></td>
<td><form  action = "ReservationController" method = "post"><button name ="btnSelect" type="submit" onClick="ReservationController">Select</button>
<input type="hidden" name = "parkingAreaName" value="<c:out value='${park.parkingAreaName}'/>" type="text" >
<input type="hidden" name = "permitType" value="<c:out value='${park.parkingType}'/>" type="text" >
<input type="hidden" name = "availableSpots" value="<c:out value='${park.pcapacity}'/>" type="text" >
<input type="hidden" name = "floor" value="<c:out value='${park.floor}'/>" type="text" >

</form></td>


</tr>
</c:forEach>
</table>

</body>
=======
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Search Results</title>
</head>
<body>
<h1>The parking spot details  are</h1>
<form action="LogoutController" method="post">
<button type="submit" style="position:fixed;right:10px;top:5px" name="btnLogout">Logout</button>
</form>
<table border="1">
<tr>
<td>Parking Area Name	</td>&nbsp;
<td>Floor 	</td>&nbsp;
<td>Parking Type	</td>&nbsp;
<td>Parking Capacity </td>
</tr>
<c:forEach items = "${parkdet}" var ="park">
<tr>
<td> <c:out value= "${park.parkingAreaName}" /></td>
<td><c:out value = "${park.floor} "/></td>
<td><c:out value= "${park.parkingType}" /></td>
<td><c:out value = "${park.pcapacity} "/></td>
<td><button type="submit">Select </button></td>
</tr>
</c:forEach>

</table>
</body>
>>>>>>> 33b67b3d4164e7ba319bd54766d6748fb733209b
</html>