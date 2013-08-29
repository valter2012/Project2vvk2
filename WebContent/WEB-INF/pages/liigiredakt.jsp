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

  <c:if test="${not empty errors}">
    <div style="color:red">
      <c:forEach var="error" items="${errors}">
        <c:out value="${error}"></c:out><br />
      </c:forEach>
    </div>
    <br/><br/>
  </c:if>
  
  <form method="POST" action="liigiredakt">
  	<input type="hidden" name="id" value="${type.id}">
  	Kood: <input name="typeKey" value="${type.key}"><br/>
  	Nimetus: <input name="typeName" value="${type.name}"><br/>
  	Kommentaar: <input name="typeComment" value="${type.comment}"><br/>
  	
  	Allub:
    <select name="subordinate">
      <c:forEach var="entry" items="${formData.ageGroups}">
        <c:set var="selected" value=""/>
        <c:if test="${entry.key == type.subordinate}">
          <c:set var="selected" value="selected=\"selected\""/>
        </c:if>
        <option value="${entry.key}" ${selected}>${entry.value}</option>
      </c:forEach>
    </select>
    
     <br/><br/>

    <input type="submit" value="Salvesta">
    <a href="index"><input type="submit" value="Loobu"></a><br/>
  	
  	
  	// lisada alluvate plok
  	
  	
  
  </form>
  <form method="get" action="/index">
  	<button type="submit">Loobu</button>
  </form>
  
  <button onclick="window.location.href='/'">Continue</button>
  

</body>
</html>