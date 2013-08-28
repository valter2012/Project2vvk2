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

 <c:if test="${not empty errors}">
    <div style="color:red">
      <c:forEach var="error" items="${errors}">
        <c:out value="${error}"></c:out><br />
      </c:forEach>
    </div>
    <br/><br/>
  </c:if>
  
  <form method="POST" action="liigiredakt">
  
	 <input type="hidden" name="id" value="${adminUnit.id}">
	 Kood: <input name="typeKey" value="${adminUnit.key}"><br/>
	 Nimetus: <input name="typeName" value="${adminUnit.name}"><br/>
	 Kommentaar: <input name="typeComment" value="${adminUnit.comment}"><br/>
	
	 <a href="index"><input type="submit" value="Loobu"></a><br/>
  	<button type="submit">Salvesta</button>
  	
  </form>
  <br/>
  <form method="POST" action="muudaLiik">
  
  	Siia tuleb Liik ${adminUnit.type}
  	<button type="submit">Muuda Liiki</button>
  
  </form>
  
   	Allub:
    <select name="subordinate">
      <c:forEach var="entry" items="${adminUnit.ageGroups}">
        <c:set var="selected" value=""/>
        <c:if test="${entry.key == adminUnit.type}">
          <c:set var="selected" value="selected=\"selected\""/>
        </c:if>
        <option value="${entry.key}" ${selected}>${entry.value}</option>
      </c:forEach>
    </select>
    
   <br/>
    
    // lisada alluvate plok

</body>
</html>