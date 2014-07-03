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
		</tr>
		<c:forEach var="uneEval"  items="${evalList}" >
		<c:if test="${uneEval.status == 'Inscrit' && uneEval.evalSession.dateFin > date}">
		<tr>
			<td><c:out value="${uneEval.evalSession.coursSession.cours.libelleCours}"/></td>
			<td><c:out value="${uneEval.evalSession.coursSession.description}"/> </td>
			<td><c:out value="${uneEval.evalSession.dateDebut}"/></td>
			<td><c:out value="${uneEval.evalSession.dateFin}"/></td>
		</tr>
		</c:if>
		</c:forEach>
	</table>
	<br>
</div>
<jsp:include page="footer.jsp"/>