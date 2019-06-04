<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete Reservation For Manager</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
</head>
<body>
<h1>Enter the ReservationID</h1>
<form action ="LogoutController" method="post">
<button type='submit' style="position:fixed;right:10px;top:5px;" name="btnLogout">Logout</button>
</form>
<form name="manager_reservationForm" action="/Maverick_parking/ReservationDeleteController" method="post">
	<label for="reservationID">ReservationID</label>
	<input type="text" class="form-control" name="reservationID"  placeholder="Enter Reservation ID">
	
	
	<button type="submit" class="btn btn-primary" name="btnSearch">Search</button>
	<input name="reservationIDError" value="<c:out value='${reservationIDerror.reservationDetailerror}'/>" type="text" style ="background-color: white; color: red; border: none; width: 800px" disabled="disabled" maxlength="60">
	
	
</form>
</body>
</html>