<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin üksuste alluvusraport</title>
</head>
<body>

	<div id="header">
		<jsp:include page="header.jsp"/>
	</div>


  
  
  <form method="POST" action="alluvusraport">
  Kuupäev: <input name="date" value="${date}">
  Liik:
  <select name="type">
      <c:forEach var="entry" items="${formData.ageGroups}">
        <c:set var="selected" value=""/>
        <c:if test="${entry.key == adminUnit.type}">
          <c:set var="selected" value="selected=\"selected\""/>
        </c:if>
        <option value="${entry.key}" ${selected}>${entry.value}</option>
      </c:forEach>
    </select>
    <button type="submit">Värskenda</button>
  </form>
  
  <a href="index"><input type="submit" value="Tagasi"></a><br/>
  
  siia alla tulevad vastused:<br/>
  <hr>
   <c:forEach var="adminUnit" items="${adminUnits}">
	   
		${adminUnit.nimetus}  ${adminUnit.kood}
	   <form method="POST" action="editAdminUnit">
	   		<input  name="id" type="hidden" value="${adminUnit.id}">
		 	<button type="submit">Muuda</button> 
		 	<!--<a href="editAdminUnit?id=${adminUnit.id}"><input type="submit" value="jama"></a>-->
	   </form>
	   <form method="POST" action="deleteAdminUnit">
	   		<input  name="id" type="hidden" value="${adminUnit.id}">
		 	<button type="submit">Kustuta</button> 
		 	<!--  <a href="deleteAdminUnit?id=${adminUnit.id}"><input type="submit" value="Kustuta"></a><br/>-->
	   </form>
	   
	   <hr>
    
  </c:forEach>
  <br/>
  

</body>
</html>