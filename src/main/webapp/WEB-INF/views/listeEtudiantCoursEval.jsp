			<jsp:include page="header.jsp"/>
			<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
			<div id="texte"><div id="overflow">
							<div class="cadre"><div class="titre"> Mes résultats </div><div class="marge_interne">

								<!-- Début de la zone de texte -->
								
								<table>
									<tr>
										<th>Matière</th>
										<th>Cours</th>
										<th>Note</th>
										<th>Status</th>
									</tr>
									<c:forEach var="unEtudiantCoursEval"  items="${etudiantCoursEvalList}" >
									<tr>
										<td><c:out value="${unEtudiantCoursEval.evalSession.coursSession.cours.libelleCours}"/></td>
										<td><c:out value="${unEtudiantCoursEval.evalSession.coursSession.description}"/></td>
										<td><c:out value="${unEtudiantCoursEval.note}"/></td>
										<td><c:out value="${unEtudiantCoursEval.status}"/></td>
									</tr>
									</c:forEach>
								</table>
								<br>
								<jsp:include page="footer.jsp"/>