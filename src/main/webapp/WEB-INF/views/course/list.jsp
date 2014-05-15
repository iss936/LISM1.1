<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="fr" >
	<head>
		<title>Titre du site</title>
	
	</head>

	<body >

		<h1>Les Cours</h1>
		<table>
									
			<c:forEach var="unCour"  items="${courseList}" >
			<tr>
				
				<td><c:out value="${unCour.libelleCours}"/></td>
				
			</tr>
			</c:forEach> 
							
		</table>
								
							
	</body>
</html>