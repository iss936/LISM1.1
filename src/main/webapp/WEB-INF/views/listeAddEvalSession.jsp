<jsp:include page="header.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="titre"> Liste de vos prochaines évaluations</div>
<div class="marge_interne">

	<!-- Début de la zone de texte -->
								
	<table>
		<tr>
			<th>Matière</th>
			<th>Cours</th>
			<th>Date de début</th>
			<th>Date de fin</th>
			<th>Type</th>
			<th></th>
		</tr>
		<c:forEach var="unCoursSession"  items="${coursSessionList}" >
		<tr>
			<td><c:out value="${unCoursSession.cours.libelleCours}"/></td>
			<td><c:out value="${unCoursSession.description}"/> </td>
			<td><c:out value="${unCoursSession.dateDebut}"/></td>
			<td><c:out value="${unCoursSession.dateFin}"/></td>
			<td><c:out value="${unCoursSession.typeCoursSession}"></c:out>
			<td><a href="frmAddEval?idCoursSession=${unCoursSession.idCoursSession}">Ajouter une évaluation</a></td>
		</tr>
		</c:forEach>
	</table>
	<br>
</div>
<jsp:include page="footer.jsp"/>