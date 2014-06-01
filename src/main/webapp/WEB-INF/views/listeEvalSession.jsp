			<jsp:include page="header.jsp"/>
			<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
			<div id="texte"><div id="overflow">
							<div class="cadre"><div class="titre"> Liste de vos prochaines évaluations</div><div class="marge_interne">

								<!-- Début de la zone de texte -->
								
								<table>
									<tr>
										<th>Matière</th>
										<th>Cours</th>
										<th>Date de début</th>
										<th>Date de fin</th>
									</tr>
									<c:forEach var="unEvalSession"  items="${evalSessionList}" >
									<tr>
										<td><c:out value="${unEvalSession.coursSession.cours.libelleCours}"/></td>
										<td><c:out value="${unEvalSession.coursSession.description}"/> </td>
										<td><c:out value="${unEvalSession.dateDebut}"/></td>
										<td><c:out value="${unEvalSession.dateFin}"/></td>
									</tr>
									</c:forEach>
								</table>
								<br>
								<jsp:include page="footer.jsp"/>