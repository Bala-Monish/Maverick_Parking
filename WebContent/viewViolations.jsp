<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Violation Details</title>
</head>
<body>
<h1>The violation details  are</h1>
<form action ="LogoutController" method="post">
<button type='submit' style="position:fixed;right:10px;top:5px;"name="btnLogout">Logout</button>
</form>
<table>
<c:forEach items = "${violation}" var ="viol">
<tr><td>No of Over-dues:<c:out value ="${viol.overdue}"/></td></tr>
<tr><td>No of No-Shows:<c:out value ="${viol.noShow}"/></td></tr>
</c:forEach>
</table>
</body>
</html>