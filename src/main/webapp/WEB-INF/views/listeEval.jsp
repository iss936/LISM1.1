<jsp:include page="header.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="titre"> D�pos de notes </div>
<div class="marge_interne">

	<!-- D�but de la zone de texte -->
<form action="addNotes">								
	<table>
		<tr>
			<th>Mati�re</th>
			<th>Cours</th>
			<th>Etudiant</th>
			<th>D�but �valuation</th>
			<th>Fin �valuation</th>
			<th></th>
		</tr>
		<c:forEach var="uneEval"  items="${lesEvalsList}" >
		<tr>
			<td><c:out value="${uneEval.evalSession.coursSession.cours.libelleCours}"/></td>
			<td><c:out value="${uneEval.evalSession.coursSession.description}"/> </td>
			<td><c:out value="${uneEval.etudiant.prenomEtudiant} ${uneEval.etudiant.nomEtudiant}"/></td>
			<td><c:out value="${uneEval.evalSession.dateDebut}"/></td>
			<td><c:out value="${uneEval.evalSession.dateFin}"/></td>
			<td><a href="frmAddNote?idEtudiant=${uneEval.etudiant.idEtudiant}&idEvalSession=${uneEval.evalSession.idEvalSession}">Saisir une note</a></td>
		</tr>
		</c:forEach>
	</table>
	</form>
	<br>
</div>
<jsp:include page="footer.jsp"/>