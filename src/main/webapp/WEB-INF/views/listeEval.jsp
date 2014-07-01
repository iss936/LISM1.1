<jsp:include page="header.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="titre"> D�pos de notes </div>
<div class="marge_interne">

	<!-- D�but de la zone de texte -->
								
	<table>
		<tr>
			<th>Mati�re</th>
			<th>Cours</th>
			<th>Etudiant</th>
			<th>D�but �valuation</th>
			<th>Fin �valuation</th>
			<th>Note</th>
		</tr>
		<c:forEach var="uneEval"  items="${lesEvalsList}" >
		<tr>
			<td><c:out value="${uneEval.evalSession.coursSession.cours.libelleCours}"/></td>
			<td><c:out value="${uneEval.evalSession.coursSession.description}"/> </td>
			<td><c:out value="${uneEval.etudiant.prenomEtudiant} ${uneEval.etudiant.nomEtudiant}"/></td>
			<td><c:out value="${uneEval.evalSession.dateDebut}"/></td>
			<td><c:out value="${uneEval.evalSession.dateFin}"/></td>
			<td><input name="note"></td>
		</tr>
		</c:forEach>
	</table>
	<br>
</div>
<jsp:include page="footer.jsp"/>