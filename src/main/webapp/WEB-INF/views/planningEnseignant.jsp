<jsp:include page="header.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="titre"> Mon planning </div>
<div class="marge_interne">

	<!-- Début de la zone de texte -->					
	<table>
		<tr>
			<th>Matière</th>
			<th>Cours</th>
			<th>Description</th>
			<th>Salle</th>
			<th>Date</th>
		</tr>
		<c:forEach var="unCours"  items="${coursSessionItemList}" >
		<tr>
			<td><c:out value="${unCours.coursSession.cours.libelleCours}"/></td>
			<td><c:out value="${unCours.coursSession.description}"/> </td>
			<td><c:out value="${unCours.descriptionDetail}"/></td>
			<td><c:out value="${unCours.salle.libelleSalle}"/></td>
			<td><c:out value="${unCours.date}"/></td>
		</tr>
		</c:forEach>
	</table>
	<br>
</div>
<jsp:include page="footer.jsp"/>