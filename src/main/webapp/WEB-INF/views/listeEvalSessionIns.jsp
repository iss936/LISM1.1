<jsp:include page="header.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="titre">Evaluations disponibles</div>
<div class="marge_interne">

	<!-- D�but de la zone de texte -->
								
	<table>
		<tr>
			<th>Mati�re</th>
			<th>Cours</th>
			<th>Date de d�but</th>
			<th>Date de fin</th>
			<th>Inscription</th>
		</tr>
		<c:forEach var="unEvalSession"  items="${evalSessionList}" >
		<tr>
			<td><c:out value="${unEvalSession.coursSession.cours.libelleCours}"/></td>
			<td><c:out value="${unEvalSession.coursSession.description}"/> </td>
			<td><c:out value="${unEvalSession.dateDebut}"/></td>
			<td><c:out value="${unEvalSession.dateFin}"/></td>
			<td><a href="inscriptionEval?idEvalSession=${unEvalSession.idEvalSession}">S'inscrire</a></td>
		</tr>
		</c:forEach>
	</table>
	<br>
</div>
<jsp:include page="footer.jsp"/>