						<jsp:include page="header.jsp"/>
						<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
						<div class="titre"> D�tails et Inscription pour le cours choisi</div>
							<div class="marge_interne">

								<!-- D�but de la zone de texte -->
								
								<table>
									<tr>
										<th>Description</th>
										<th>Enseignant</th>
										<th>Salle</th>
									</tr>
									<c:forEach items="${coursSessionItemList}" var="unCoursSessionItem">
										<tr>
											<td><c:out value="${unCoursSessionItem.descriptionDetail}"/></td>
											<td><c:out value="${unCoursSessionItem.enseignant.prenomEnseignant} ${unCoursSessionItem.enseignant.nomEnseignant}"/></td>
											<td><c:out value="${unCoursSessionItem.salle.libelleSalle}"/></td>
										</tr>
									</c:forEach>
									<tr>
										<td colspan ="3" align="center">
										<form method="POST" action="InscriptionCours">
											<input type="hidden" value="${idCoursSession}" name="idCoursSession">
											<input type="submit" value="S'incrire" >
											<input type="button" onclick="javascript:history.back()" value="Retour" >
										</form>
										</td>
									</tr>
								</table>
								<br>
								
								<!-- Fin de la zone de texte -->
								
								</div>
								<jsp:include page="footer.jsp"/>