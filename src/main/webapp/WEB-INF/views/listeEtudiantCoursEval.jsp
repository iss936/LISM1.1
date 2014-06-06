			<jsp:include page="header.jsp"/>
			<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
			<div class="titre"> Mes r�sultats </div>
			<div class="marge_interne">

								<!-- D�but de la zone de texte -->
								
								<table>
									<tr>
										<th>Mati�re</th>
										<th>Cours</th>
										<th>Note</th>
									</tr>
									<c:forEach var="unEtudiantCoursEval"  items="${etudiantCoursEvalList}" >
									<c:if test="${unEtudiantCoursEval.status == 'Pass�'}">
									<tr>
										<td><c:out value="${unEtudiantCoursEval.evalSession.coursSession.cours.libelleCours}"/></td>
										<td><c:out value="${unEtudiantCoursEval.evalSession.coursSession.description}"/></td>
										<td><c:out value="${unEtudiantCoursEval.note}"/></td>
									</tr>
									</c:if>
									</c:forEach>
								</table>
								<br>
								</div>
								<jsp:include page="footer.jsp"/>