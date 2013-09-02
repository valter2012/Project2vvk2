<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin üksuse liigi struktuur</title>
</head>
<body>

<div id="header">
	<jsp:include page="header.jsp"/>
</div>

<br/>
  <hr>
   <c:forEach var="adminUnitType" items="${adminUnitTypes}">
	   
		${adminUnitType.nimetus}  ${adminUnitType.kood}
	   <form method="POST" action="editAdminUnitType">
	   		<input  name="id" type="hidden" value="${adminUnitType.id}">
		 	<button type="submit">Muuda</button> 
		 	<!--<a href="editAdminUnitType?id=${adminUnit.id}"><input type="submit" value="jama"></a>-->
	   </form>
	   <form method="POST" action="deleteAdminUnitType">
	   		<input  name="id" type="hidden" value="${adminUnitType.id}">
		 	<button type="submit">Kustuta</button> 
		 	<!--  <a href="deleteAdminUnitType?id=${adminUnit.id}"><input type="submit" value="Kustuta"></a><br/>-->
	   </form>
	   
	   <hr>
    
  </c:forEach>
<a href="index"><input type="submit" value="Tagasi"></a><br/>

</body>
</html>