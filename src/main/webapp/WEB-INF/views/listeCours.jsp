			<jsp:include page="header.jsp"/>
			<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
			<div class="titre"> Liste des cours pour la mati�re suivante : <c:out value="${cours.libelleCours}"/></div>
			<div class="marge_interne">

								<!-- D�but de la zone de texte -->
								<h1>Cours pr�sentiel</h1>
								<table>
									<tr>
										<th>Intitul�</th>
										<th>Date de d�but</th>
										<th>Date de fin</th>
										<th>En savoir plus</th>
									</tr>
									<c:forEach var="unCoursSession"  items="${coursSessionList}" >
										<c:if test="${unCoursSession.typeCoursSession=='Pr�sentiel'}">
											<tr>
												<td><c:out value="${unCoursSession.description}"/></td>
												<td><c:out value="${unCoursSession.dateDebut}"/> </td>
												<td><c:out value="${unCoursSession.dateFin}"/></td>
												<td><a href="FicheCoursSessionItem?idCoursSession=${unCoursSession.idCoursSession}">En savoir plus</a></td>
											</tr>
										</c:if>
									</c:forEach>
								</table>
								<br><br>
								
								<h1>Cours en ligne</h1>
								<table>
									<tr>
										<th>Intitul�</th>
										<th>Date de d�but</th>
										<th>Date de fin</th>
										<th>En savoir plus</th>
									</tr>
									<c:forEach var="unCoursSession" items="${coursSessionList}">
										<c:if test="${unCoursSession.typeCoursSession=='En ligne'}">
											<tr>
												<td><c:out value="${unCoursSession.description}"/></td>
												<td><c:out value="${unCoursSession.dateDebut}"/></td>
												<td><c:out value="${unCoursSession.dateFin}"/></td>
												<td><a href="FicheCoursSessionItem?idCoursSession=${unCoursSession.idCoursSession}">En savoir plus</a></td>
											</tr>
										</c:if>
									</c:forEach>
								</table>
								<br>
								
								</div>
								<jsp:include page="footer.jsp"/>