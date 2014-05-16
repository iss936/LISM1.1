			<jsp:include page="header.jsp"/>
			<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
			<div id="texte"><div id="overflow">
							<div class="cadre"><div class="titre"> Liste des cours pour la mati�re suivante : <c:out value="${cours.libelleCours}"/></div><div class="marge_interne">

								<!-- D�but de la zone de texte -->
								
								<table>
									<tr>
										<th>Intitul�</th>
										<th>Date de d�but</th>
										<th>Date de fin</th>
										<th>Type de cours</th>
										<th>En savoir plus</th>
									</tr>
									<c:forEach var="unCoursSession"  items="${coursSessionList}" >
									<tr>
										<td><c:out value="${unCoursSession.description}"/></td>
										<td><c:out value="${unCoursSession.dateDebut}"/> </td>
										<td><c:out value="${unCoursSession.dateFin}"/></td>
										<td><c:out value="${unCoursSession.typeCoursSession}"/></td>
										<td><a href="FicheCoursSessionItem?idCoursSession=${unCoursSession.idCoursSession}">En savoir plus</a></td>
									</tr>
									</c:forEach>
								</table>
								<br>
								<jsp:include page="footer.jsp"/>