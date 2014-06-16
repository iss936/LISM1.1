		<jsp:include page="../header.jsp"/>
		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 		<%java.text.DateFormat df = new java.text.SimpleDateFormat("dd/MM/yyyy"); %>
		<div class="titre">Mes Cours</div>
			<table border="1">
				<tr>
					<th>Cours</th>
					<th>Date de début</th>
					<th>Date de fin</th>
					<th>Description</th>
					<th>Type</th>
					<th>Professeurs </th>
					<th>Présence</th>
					<th>Se désinscrire ?</th>
				</tr>
			
			<c:forEach var="unCour"  items="${myCourses}" >
				<tr>
					<td>${unCour.cours.libelleCours}</td>
					<td>${unCour.dateDebut}</td>
					<td>${unCour.dateFin}</td>
					<td>${unCour.description}</td>
					<td>${unCour.typeCoursSession}</td>
					<td><a href="FicheCoursSessionItem?idCoursSession=${unCour.idCoursSession}">En savoir plus</a></td>
					<td>En attente</td>
					<td><a onclick="return(confirm('Voulez-vous vous désinscrire ?'));" href="DesinscriptionCours?idCoursSession=${unCour.idCoursSession}">Se désinscrire</a></td>
					
				</tr>
			</c:forEach> 
			</table>			
		<jsp:include page="../footer.jsp"/>