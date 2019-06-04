<<<<<<< HEAD
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Maverick Parking Login</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
</head>
<body>
<div class="jumbotron">
<h1 align ="center"> Welcome to Maverick Parking System</h1>
</div>
<div class="container" align="center">
  <h2 class="display-4" align = "center">Login</h2>
  <form action="LoginController" method="post">
  <div class="form-group">
    <label for="userName" align="left">User Name (Email)</label>
    <input type="email" class="form-control" name="userName" aria-describedby="emailHelp" placeholder="Enter email">
  </div>
  <div class="form-group">
    <label for="password" align="left">Password</label>
    <input type="password" class="form-control" name="password" placeholder="Password" ><br>
    <input name="userNamePasswordError" value="<c:out value='${errorMsgs.userNamePasswordError}'/>" type="text" style ="background-color: white; color: red; border: none; width: 800px" disabled="disabled" maxlength="60">
    <br><button type="submit" class="btn btn-primary" name="btnLogin">Login</button>
  </div>
 </form>
  <div>
  <p align="center">New User?</p>
  <form action="register.jsp">
  <button type="submit" class="btn btn-primary">Register</button>
  </form>
  </div>
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
<title>Maverick Parking Login</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
</head>
<body>
<div class="jumbotron">
<h1 align ="center"> Welcome to Maverick Parking System</h1>
</div>
<div class="container" align="center">
  <h2 class="display-4" align = "center">Login</h2>
  <form action="LoginController" method="post">
  <div class="form-group">
    <label for="userName" align="left">User Name (Email)</label>
    <input type="email" class="form-control" name="userName" aria-describedby="emailHelp" placeholder="Enter email">
  </div>
  <div class="form-group">
    <label for="password" align="left">Password</label>
    <input type="password" class="form-control" name="password" placeholder="Password" ><br>
    <input name="userNamePasswordError" value="<c:out value='${errorMsgs.userNamePasswordError}'/>" type="text" style ="background-color: white; color: red; border: none; width: 800px" disabled="disabled" maxlength="60">
    <button type="submit" class="btn btn-primary" name="btnLogin">Login</button>
  </div>
 </form>
  <div>
  <p align="center">New User?</p>
  <form action="register.jsp">
  <button type="submit" class="btn btn-primary">Register</button>
  </form>
  </div>
</div>
</body>
>>>>>>> 33b67b3d4164e7ba319bd54766d6748fb733209b
</html>