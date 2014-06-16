<jsp:include page="header.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="titre"> Liste de vos prochaines �valuations</div>
<div class="marge_interne">

	<!-- D�but de la zone de texte -->
								
	<table>
		<tr>
			<th>Mati�re</th>
			<th>Cours</th>
			<th>Date de d�but</th>
			<th>Date de fin</th>
		</tr>
		<c:forEach var="unEvalSession"  items="${evalSessionList}" >
		<c:if test="${unEvalSession.status == 'Inscrit'}">
		<tr>
			<td><c:out value="${unEvalSession.evalSession.coursSession.cours.libelleCours}"/></td>
			<td><c:out value="${unEvalSession.evalSession.coursSession.description}"/> </td>
			<td><c:out value="${unEvalSession.evalSession.dateDebut}"/></td>
			<td><c:out value="${unEvalSession.evalSession.dateFin}"/></td>
		</tr>
		</c:if>
		</c:forEach>
	</table>
	<br>
</div>
<jsp:include page="footer.jsp"/>