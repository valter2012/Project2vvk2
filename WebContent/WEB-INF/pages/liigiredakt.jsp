<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin üksuse liigi redaktor</title>
</head>
<body>

	<div id="header">
		<jsp:include page="header.jsp"/>
	</div>

  <c:if test="${not empty errors}">
    <div style="color:red">
      <c:forEach var="error" items="${errors}">
        <c:out value="${error}"></c:out><br />
      </c:forEach>
    </div>
    <br/><br/>
  </c:if>
  
  <form method="POST" action="liigiredakt">
  	<input type="hidden" name="id" value="${adminUnitType.id}">
  	Kood: <input name="kood" value="${adminUnitType.kood}"><br/>
  	Nimetus: <input name="nimetus" value="${adminUnitType.nimetus}"><br/>
  	Kommentaar: <input name="kommentaar" value="${adminUnitType.kommentaar}"><br/>
  	
  	Allub:

    
     <br/><br/>

    <input type="submit" value="Salvesta">
    
  	
  	
  	// lisada alluvate plok
  	
  	
  
  </form>
  <a href="index"><input type="submit" value="Loobu"></a><br/>
 
  

</body>
</html>