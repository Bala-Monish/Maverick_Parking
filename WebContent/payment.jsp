<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Payment Page</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
</head>
<body>
<div align="center">
<h2>Payment Page</h2>
</div>
<form action = "PayAndReserveController" method="post">
<div align="center" class="form-group">
<label for="totalCost">Total cost of Reservation (USD):</label>
<input name = "totalCost" type="text" value = "<c:out value='${payment.totalCost}'/>" disabled ="disabled">
</div>
<div align="center" class="form-group">
<label for="cardNumber">Credit Card Number</label>
<input name="cardNumber" type="text" value = "<c:out value='${payment.cardNumber}'/>">
</div>
<div align="center" class="form-group">
<label>Credit Card Type</label>
<select class="form-control">
  <option>American Express</option>
  <option>Discover</option>
  <option>MasterCard</option>
  <option>Visa</option>
</select>
</div>
<div align="center" class="form-group">
<button  name = "btnPay" type = "submit">Pay and Reserve</button>
<button  name = "btnBack"type = "submit">Back</button>
</div>
</form>
</body>
</html>