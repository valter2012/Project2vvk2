<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="./css/style.css">
</head>
<body>
	<table style="width: 100%">
			<tr>
				<td style="width: 20%;x">
					<a href="?lang=en">English</a>
					<a href="?lang=et">Eesti keel</a>
				</td>
				
				<td align="center">
					
					Piirivalve rakendus
				</td>
				
				<td style="width: 20%;text-align: right;padding-right: 10px">
					<sec:authorize ifAnyGranted="ROLE_ADMIN,ROLE_USER">
						<a href="logout"><spring:message code="header.link.logout"/></a>				
					</sec:authorize>
						
				</td>
				
			</tr>
	</table>
	<hr>


</body>
</html>