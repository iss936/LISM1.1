			<jsp:include page="header.jsp"/>
			<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
			<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
			<div class="titre"> Liste des professeurs</div>
			<div class="marge_interne">

								<!-- Début de la zone de texte -->
								<form action="delEnseignant" method="post">
									<table>
										<tr>
											<th>Prénom</th>
											<th>Nom</th>
											<th>Nombre de cours attribués</th>
											<th>Supprimer ?</th>
										</tr>
										<c:forEach var="unEnseignant"  items="${enseignantList}" >
										<tr>
											<td><c:out value="${unEnseignant.prenomEnseignant}"/></td>
											<td><c:out value="${unEnseignant.nomEnseignant}"/> </td>
											<td><c:out value="${fn:length(unEnseignant.lesCoursSessionItem)}"/></td>
											<td><c:if test="${fn:length(unEnseignant.lesCoursSessionItem) == 0}"><input type="checkbox" name="idEnseignant" value="${unEnseignant.idEnseignant}"></c:if></td>
										</tr>
										</c:forEach>
										<tr>
											<td colspan="4"><input type="submit" value="Supprimer"></td>
										</tr>
									</table>
								</form>
								<br>
								
								</div>
								<jsp:include page="footer.jsp"/>