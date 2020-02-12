<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Ninja</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<div class="container">
<h1>New Ninja</h1>
<form:form action="/ninjas/new" type="POST" modelAttribute="ninjas">
    <p>
        <form:label path="dojo">Dojo:</form:label>
        <form:errors path="dojo"/>
        <form:select path="dojo"><c:forEach items="${dojo}" var="dojo">
        <form:option value="${dojo.id}"><c:out value="${dojo.name}"/></form:option>
        </c:forEach></form:select>
    </p>
    <p>
        <form:label path="firstName">First Name:</form:label>
        <form:errors path="firstName"/>
        <form:input path="firstName"/>
    </p>
    <p>
        <form:label path="lastName">Last Name:</form:label>
        <form:errors path="lastName"/>
        <form:input path="lastName"/>
    </p>
    <p>
        <form:label path="age">Age:</form:label>
        <form:errors path="age"/>
        <form:input path="age" type="num"/>
    </p> 
    <input type="submit" value="Submit"/>
</form:form>
</div>
</body>
</html>