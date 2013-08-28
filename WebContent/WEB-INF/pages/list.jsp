<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>

  <c:forEach var="person" items="${persons}">
    <a href="edit?id=${person.id}">${person.firstName} ${person.name}</a>&nbsp;
    <a href="delete?id=${person.id}">Kustuta</a><br/><br/>
  </c:forEach>

  <br/><br/>
  <a href="form">Lisa isik</a><br/>

</body>
</html>