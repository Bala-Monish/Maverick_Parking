<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modify Reservation</title>
</head>
<body>
<div align="center">
<h3>Modify Reservation</h3>
</div>
<form action="UpdateReservationController" method = post>
<div align = "center">
<h4>Modify options</h4><br>
<p>Reservation ID:<input type = "text" name = "reservationID" value="<c:out value='${modifyReservation.reservationID}'/>" disabled = "disabled"></p>


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
</div>
<div align = "center">
<h4>Modify Duration</h4>
<label for="startTime">Start Time (HH:mm:ss)</label>
<input type="text" name="startTime" value = "<c:out value='${modifyReservation.startTime}'/>" disabled = "disabled">
</div>
<div align = "center">
<label for="duration">Duration(Minutes, max:180)</label><br>
    <select class="form-control w-25 d-inline-block" name="duration">
    <option>15</option>
    <option>30</option>
    <option>45</option>
    <option>60</option>
    <option>75</option>
    <option>90</option>
    <option>105</option>
    <option>120</option>
    <option>135</option>
    <option>150</option>
    <option>165</option>
    <option>180</option>
    </select>

</div>
<div align = "center"> <button name = "btnConfirmModify" type="submit">Modify Reservation</button><button name="btnBack" type = "submit">Back</button></div>
</form>
</body>

</html>