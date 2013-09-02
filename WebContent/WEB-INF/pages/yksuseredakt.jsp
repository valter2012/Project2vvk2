<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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
	Name: <input name="nimetus" value="${adminUnit.nimetus}"><br/>
	Kommentaar: <input name="kommentaar" value="${adminUnit.kommentaar}"><br/>
	Allub:<br/>
	
	Liik: 
  	<select name="adminUnitTypeSelect">
      <c:forEach var="entry" items="${adminUnitTypes}">
        <c:set var="selected" value=""/>
        <c:if test="${entry.key == adminUnitType.id}">
          <c:set var="selected" value="selected=\"selected\""/>
        </c:if>
        <option value="${entry.key}" ${selected}>${entry.value}</option>
      </c:forEach>
    </select>
	
	<br/>
  	<button type="submit" value="Salvesta">Salvesta</button>
  	<a href="index"><input type="submit" value="Tagasi"></a><br/>
  	
  </form>

   <br/>
  Alluvad:
    // lisada alluvate plok<br/><br/>
    
    <form method="POST" action="addSub">
    	<input  name="headUnitId" type="hidden" value="${adminUnit.id}">
	    Lisa: 
	  	<select name="subUnitId">
	      <c:forEach var="entry" items="${adminUnits}">
	        <c:set var="selected" value=""/>
	        <option value="${entry.key}" ${selected}>${entry.value}</option>
	      </c:forEach>
	    </select>
	    <button type="submit" value="Lisa">Lisa</button>
    </form>
     <br/>
    <!--   TODO lihtsalt testimiseks, et toimib
    All Data Block for test <br/>
    Liik: ${adminUnit.type_id} -- ${adminUnitType.nimetus}<br/>
    Id: ${adminUnit.id} <br/>
  	Kood: ${adminUnit.kood}<br/>
  	Nimetus: ${adminUnit.nimetus}<br/>
  	Kommentaar: ${adminUnit.kommentaar}<br/>
  	Liik: ${adminUnit.type_id}<br/>
  	avaja: ${adminUnit.avaja}<br/>
  	avatud: ${adminUnit.avatud}<br/>
  	muutja: ${adminUnit.muutja}<br/>
  	muudetud: ${adminUnit.muudetud}<br/>
  	sulgeja: ${adminUnit.sulgeja}<br/>
  	suletud: ${adminUnit.suletud}<br/>
  	alates: ${adminUnit.suletud}<br/>
  	kuni: ${adminUnit.suletud}<br/>
-->
</body>
</html>