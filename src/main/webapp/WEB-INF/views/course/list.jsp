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
			<tr>
			
			<td>Intitulé</td>
			<td>Date Debut</td>
			<td>Date Fin</td>
			<td>Type de Cours</td>
			<td>Détails</td>
			
			</tr>
									
			<c:forEach var="unCour"  items="${courseList}" >
			<tr>
				<td><c:out value="${unCour.idCours}"/></td>
				<td><c:out value="${unCour.libelleCours}"/></td>
				
				<%-- <td><c:out value="${unCour.getDateDebut()}"/></td> --%>
				<%-- <td><% out.print(lesCoursSession.get(i).getTypeCoursSession()); %></td>
				<td><a href="FicheCoursSessionItem?idCoursSession=<% out.print(lesCoursSession.get(i).getIdCoursSession()); %>">En Savoir Plus</a></td> --%>
			</tr>
			</c:forEach> 
							
		</table>
								
							
	</body>
</html>