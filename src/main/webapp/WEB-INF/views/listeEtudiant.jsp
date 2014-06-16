			<jsp:include page="header.jsp"/>
			<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
			<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
			<div class="titre"> Liste des étudiants</div>
			<div class="marge_interne">

								<!-- Début de la zone de texte -->
								<form action="delEtudiant" method="post">
									<table>
										<tr>
											<th>Prénom</th>
											<th>Nom</th>
											<th>Supprimer ?</th>
										</tr>
										<c:forEach var="unEtudiant"  items="${etudiantList}" >
										<tr>
											<td><c:out value="${unEtudiant.prenomEtudiant}"/></td>
											<td><c:out value="${unEtudiant.nomEtudiant}"/> </td>
											<td><input type="checkbox" name="idEtudiant" value="${unEtudiant.idEtudiant}"></td>
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