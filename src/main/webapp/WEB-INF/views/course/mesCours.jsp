		<jsp:include page="../header.jsp"/>
		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 		<%java.text.DateFormat df = new java.text.SimpleDateFormat("dd/MM/yyyy"); %>
		<div class="titre">Mes Cours</div>
			<table border="1">
				<tr>
					<td> Cours</td>
					<td> Date de début</td>
					<td> Date de fin</td>
					<td> Description</td>
					<td> type</td>
					<td>Professeur</td>
					<td>Présence</td>
				</tr>
			
			<c:forEach var="unCour"  items="${myCourses}" >
				<tr>
					<td>${unCour.cours.libelleCours}</td>
					<td>${unCour.dateDebut}</td>
					<td>${unCour.dateFin}</td>
					<td>${unCour.description}</td>
					<td>${unCour.typeCoursSession}</td>
					<td>toto</td>
					<td>En attente</td>
					
				</tr>
			</c:forEach> 
			</table>			
		<jsp:include page="../footer.jsp"/>