<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dojo View</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<h1><c:out value="${dojo.name}"></c:out> Location Ninjas</h1>
<table class="table table-dark">
  <thead>
    <tr>
      <th scope="col">First Name</th>
      <th scope="col">Last Name</th>
      <th scope="col">Age</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${dojo.ninjas}" var="ninja">
    <tr>
      <td><c:out value="${ninja.firstName}"></c:out></td>
      <td><c:out value="${ninja.lastName}"></c:out></td>
      <td><c:out value="${ninja.age}"></c:out></td>
    </tr>
    </c:forEach>
  </tbody>
</table>
</body>
</html>