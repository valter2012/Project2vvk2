<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin üksuse redaktor</title>
</head>
<body>

<div id="header">
	<jsp:include page="header.jsp"/>
</div>

${message}
 <c:if test="${not empty errors}">
    <div style="color:red">
      <c:forEach var="error" items="${errors}">
        <c:out value="${error}"></c:out><br />
      </c:forEach>
    </div>
    <br/><br/>
  </c:if>
  
  <form method="POST" action="yksuseredakt">
  		
	 <input  name="id" type="hidden" value="${adminUnit.id}">
	 Kood: <input name="kood" value="${adminUnit.kood}"><br/>
	 Nimetus: <input name="nimetus" value="${adminUnit.nimetus}"><br/>
	 Kommentaar: <input name="kommentaar" value="${adminUnit.kommentaar}"><br/>
	
	
  	<button type="submit">Salvesta</button>
  	<a href="index"><input type="submit" value="Loobu"></a><br/>
  	
  </form>
  <br/>
  <form method="POST" action="muudaLiik">
  
  <!--   TODO lihtsalt testimiseks, et toimib-->
  ${adminUnit.id} <br/>
  ${adminUnit.kood}<br/>
  	Siia tuleb Liik ${adminUnit.type_id}
  	<button type="submit">Muuda Liiki</button>
  
  </form>
  
   <br/>
    
    // lisada alluvate plok

</body>
</html>