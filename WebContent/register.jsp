<<<<<<< HEAD
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
</head>
<body>
<div align="center">
<h1>Please Enter the Following Details</h1>
</div>
<div>
<input name="errorMsg" value="<c:out value='${errorMsgs.errorMsg}'/>" type="text" style ="background-color: white; color: red; border: none; width:800px" disabled="disabled">
</div>
<div class="container" align="center">
<form name="registerForm" action="/Maverick_parking/SystemUserController" method="post">
  <div class="form-group">
    <label for="userName">User Name (Email)</label>
    <input type="text" class="form-control" name="userName"  placeholder="example@xyz.com">
    <br> <input name="userNameError" value="<c:out value='${errorMsgs.userNameError}'/>" type="text" style ="background-color: white; color: red; border: none; width: 800px" disabled="disabled" maxlength="60">
    
  </div>
  <div class="form-group">
    <label for="password">Password</label>
    <input type="password" class="form-control" name="password" placeholder="Password">
    <br>
    <input name="passwordError" value="<c:out value='${errorMsgs.passwordError}'/>" type="text" style ="background-color: white; color: red; border: none; width: 800px" disabled="disabled" maxlength="60">
  </div>
   <div class="form-group">
    <label for="cpassword">Confirm Password</label>
    <input type="password" class="form-control" name="cpassword" placeholder="Confirm Password">
    <br>
    <input name="cpasswordError" value="<c:out value='${errorMsgs.cpasswordError}'/>" type="text" style ="background-color: white; color: red; border: none; width: 800px" disabled="disabled" maxlength="60">
  </div>
  <div class="form-group">
    <label for="name">Name</label>
    <input type="text" class="form-control" name="name"  placeholder="First Name and Last Name">
    <br>
    <input name="nameError" value="<c:out value='${errorMsgs.nameError}'/>" type="text" style ="background-color: white; color: red; border: none; width: 800px" disabled="disabled" maxlength="60">
  </div>
  <div class="form-group">
    <label for="roleType">Role Type</label>
    <select class="form-control" name="roleType">
      <option>User</option>
      <option>Manager</option>
      <option>Admin</option>
    </select>
  </div>
 
  <button type="submit" class="btn btn-primary" name="btnRegister">Register</button>
  </form>
</div>
</body>
=======
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
</head>
<body>
<div align="center">
<h1>Please Enter the Following Details</h1>
</div>
<div>
<input name="errorMsg" value="<c:out value='${errorMsgs.errorMsg}'/>" type="text" style ="background-color: white; color: red; border: none; width:800px" disabled="disabled">
</div>
<div class="container" align="center">
<form name="registerForm" action="/Maverick_parking/SystemUserController" method="post">
  <div class="form-group">
    <label for="userName">User Name (Email)</label>
    <input type="text" class="form-control" name="userName"  placeholder="example@xyz.com">
    <br> <input name="userNameError" value="<c:out value='${errorMsgs.userNameError}'/>" type="text" style ="background-color: white; color: red; border: none; width: 800px" disabled="disabled" maxlength="60">
    
  </div>
  <div class="form-group">
    <label for="password">Password</label>
    <input type="password" class="form-control" name="password" placeholder="Password">
    <br>
    <input name="passwordError" value="<c:out value='${errorMsgs.passwordError}'/>" type="text" style ="background-color: white; color: red; border: none; width: 800px" disabled="disabled" maxlength="60">
  </div>
   <div class="form-group">
    <label for="cpassword">Confirm Password</label>
    <input type="password" class="form-control" name="cpassword" placeholder="Confirm Password">
    <br>
    <input name="cpasswordError" value="<c:out value='${errorMsgs.cpasswordError}'/>" type="text" style ="background-color: white; color: red; border: none; width: 800px" disabled="disabled" maxlength="60">
  </div>
  <div class="form-group">
    <label for="name">Name</label>
    <input type="text" class="form-control" name="name"  placeholder="First Name and Last Name">
    <br>
    <input name="nameError" value="<c:out value='${errorMsgs.nameError}'/>" type="text" style ="background-color: white; color: red; border: none; width: 800px" disabled="disabled" maxlength="60">
  </div>
  <div class="form-group">
    <label for="roleType">Role Type</label>
    <select class="form-control" name="roleType">
      <option>User</option>
      <option>Manager</option>
      <option>Admin</option>
    </select>
  </div>
 
  <button type="submit" class="btn btn-primary" name="btnRegister">Register</button>
  </form>
</div>
</body>
>>>>>>> 33b67b3d4164e7ba319bd54766d6748fb733209b
</html>