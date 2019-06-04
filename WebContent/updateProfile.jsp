<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create User Profile</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
</head>
<body>
<div align="center">
<h1>Please Enter the Following Details</h1>
</div>
<div align = "center" class = "container">
<form name="createProfileForm" action="/Maverick_parking/UpdateProfileController" method="post">
  <div class="form-group">
  	<label for="password">Password</label>
    <input type="password" class="form-control" name="password"  value = "<c:out value='${updateProfile.password}'/>">
    <input name="passwordError" value="<c:out value='${updateError.passwordError}'/>" type="text" style ="background-color: white; color: red; border: none; width: 800px" disabled="disabled" maxlength="60">
    <br>
    <label for="cpassword">Password</label>
    <input type="password" class="form-control" name="cpassword"  placeholder="Confirm Password">
    <input name="passwordError" value="<c:out value='${updateError.passwordError}'/>" type="text" style ="background-color: white; color: red; border: none; width: 800px" disabled="disabled" maxlength="60">
    <label for="address">Address</label>
    <input type="text" class="form-control" name="address"  value = "<c:out value='${updateProfile.address}'/>">
    <br>
    <label for="phone">Phone</label>
    <input type="text" class="form-control" name="phone"  value = "<c:out value='${updateProfile.phone}'/>">
    <input name="phoneNumberError" value="<c:out value='${updateError.phoneNumberError}'/>" type="text" style ="background-color: white; color: red; border: none; width: 800px" disabled="disabled" maxlength="60">
    
    <br>
     <label for="utaId">UTA ID</label>
    <input type="text" class="form-control" name="utaId"  value = "<c:out value='${updateProfile.utaId}'/>" readonly = "readonly">
    <input name="utaIdError" value="<c:out value='${updateError.utaIdError}'/>" type="text" style ="background-color: white; color: red; border: none; width: 800px" disabled="disabled" maxlength="60">
    
    <br>
    <label for="carLicense">Car License</label>
    <input type="text" class="form-control" name="carLicense" value = "<c:out value='${updateProfile.carLicense}'/>">
    <input name="carLicenseError" value="<c:out value='${updateError.carLicenseError}'/>" type="text" style ="background-color: white; color: red; border: none; width: 800px" disabled="disabled" maxlength="60">
    
    <br>
    <label for="creditCard">Credit Card Number</label>
    <input type="text" class="form-control" name="creditCard"  value = "<c:out value='${updateProfile.creditCard}'/>">
    <input name="creditCardError" value="<c:out value='${updateError.creditCardError}'/>" type="text" style ="background-color: white; color: red; border: none; width: 800px" disabled="disabled" maxlength="60">
    
     <br>
    <label for="permitType">Permit Type</label>
    <select class="form-control w-25 d-inline-block" name="permitType">
    <option>Basic</option>
    <option>Midrange</option>
    <option>Access</option>
    <option>Premium</option>
    </select>
    <br>
    <br>
     <button type="submit" class="btn btn-primary" name="btnRegister">update</button>
    </div>
    </form>
    </div>
    </body>
    </html>
    