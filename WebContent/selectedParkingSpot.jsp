<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Selected Parking Spot</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
</head>
<body>
<form action ="LogoutController" method="post">
<button type='submit' style="position:fixed;right:10px;top:5px;"name="btnLogout">Logout</button>
</form>
<div align="center">
<h2>Reserve a Parking Spot</h2>
</div>
<div align="center">
<h3>Selected Parking Spot Details</h3><br>
<label>User Name:</label>
<input name="userName" value="<c:out value='${reservation.userName}'/>" type="text" disabled="disabled">
<table border="1">
<tr>
<td><p>Parking Area Name</p></td>
<td><c:out value="${reservation.parkingAreaName}"/></td>
</tr>
<tr>
<td><p>Parking Type</p>
<td><c:out value="${reservation.permitType}"/></td>
</tr>
<tr>
<td><p>Available Spots (capacity)</p>
<td><c:out value="${reservation.availableSpots}"/></td>
</tr>
<tr>
<td><p>Floor</p>
<td><c:out value="${reservation.floor}"/></td>
</tr>
<tr>
<td><p>Start Time</p></td>
<td><c:out value="${reservation.startTime}"/></td>
</tr>
<tr>
<td><p>End Time</p></td>
<td><c:out value="${reservation.endTime}"/></td>
</tr>
<tr>
<td><p>Duration (Minutes)</p></td>
<td><c:out value="${reservation.duration}"/></td>
</tr>
</table><br>
</div>
<div align="center">
<h3>Select the following Option(s) [optional]</h3>
<form action="PaymentController" method = post>
<div class="form-check form-check-inline">
  <input class="form-check-input" type="checkbox" name="camera" value="2.95">
  <label class="form-check-label" for="camera">Camera($2.95)</label>
</div>
<div class="form-check form-check-inline">
  <input class="form-check-input" type="checkbox" name = "cart" value="15.95">
  <label class="form-check-label" for="cart">Cart($15.95)</label>
</div>
<div class="form-check form-check-inline">
  <input class="form-check-input" type="checkbox" name = "history" value="1.95">
  <label class="form-check-label" for="history">History($1.95)</label>
</div>
<button name= "btnPay" type="submit">Go to Payment</button>
<button type="submit">Back</button>
<div>
<input name="errorMsg" value="<c:out value='${resersvationErrorMsgs.errorMsg}'/>" type="text" style ="background-color: white; color: red; border: none; width: 800px" disabled="disabled" maxlength="60">
</div>
<div>
</div>
<div>
<input name="userRevokedErrorMsg" value="<c:out value='${resersvationErrorMsgs.userRevokedErrorMsg}'/>" type="text" style ="background-color: white; color: red; border: none; width: 800px" disabled="disabled" maxlength="60">
</div>
<div>
<input name="cartErrorMsg" value="<c:out value='${resersvationErrorMsgs.cartErrorMsg}'/>" type="text" style ="background-color: white; color: red; border: none; width: 800px" disabled="disabled" maxlength="60">
</div>

</form>
</div>

</body>
</html>