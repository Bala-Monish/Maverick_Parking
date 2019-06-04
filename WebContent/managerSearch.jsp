<<<<<<< HEAD
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manager Search for User</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
</head>
<body>
<form action="LogoutController" method="post">
<button type="submit" style="position:fixed;right:10px;top:5px" name="btnLogout">Logout</button>
</form>
<h1>Enter the Name of the User</h1>
<form name="manager_searchForm" action="/Maverick_parking/ManagerSearchController" method="post">
    <label for="name">Name</label>
    <input type="email" class="form-control" name="uname"  placeholder="Enter User Name">
    
    <button type="submit" class="btn btn-primary" name="btnSearch">Search</button>
    <input name="userNameError" value="<c:out value='${managerError.userNameError}'/>" type="text" style ="background-color: white; color: red; border: none; width: 800px" disabled="disabled" maxlength="60">
  </form>
</body>
=======
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manager Search for User</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
</head>
<body>
<form action="LogoutController" method="post">
<button type="submit" style="position:fixed;right:10px;top:5px" name="btnLogout">Logout</button>
</form>
<h1>Enter the Name of the User</h1>
<form name="manager_searchForm" action="/Maverick_parking/ManagerSearchController" method="post">
    <label for="name">Name</label>
    <input type="email" class="form-control" name="uname"  placeholder="Enter User Name">
    
    <button type="submit" class="btn btn-primary" name="btnSearch">Search</button>
    <input name="userNameError" value="<c:out value='${managerError.userNameError}'/>" type="text" style ="background-color: white; color: red; border: none; width: 800px" disabled="disabled" maxlength="60">
  </form>
</body>
>>>>>>> 33b67b3d4164e7ba319bd54766d6748fb733209b
</html>