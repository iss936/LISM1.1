			<jsp:include page="header.jsp"/>
			<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
								<div class="titre">Ajouter un cours</div>
								<div class="marge_interne">

								<!-- Début de la zone de texte -->
								
								<form action="addCoursSession" method="post">
								
									<label for="idCours">Matière *</label>
									<select name="idCours">
									<c:forEach  var="unCours"  items="${coursList}">
										<option value="${unCours.idCours}"><c:out value="${unCours.libelleCours}"></c:out></option>
									</c:forEach>
									</select><br><br>
									
									<label for="dateDebut">Date de début *</label>
									<input type="text" name="dateDebut" required="required" class="datepicker"><br><br>
									
									<label for="dateFin">Date de fin *</label>
									<input type="text" name="dateFin" required="required" class="datepicker"><br><br>
									
									<label for="description">Description *</label>
									<textarea rows="3" name="description" required="required"></textarea><br><br>
									
									<label for="type">Type *</label>
									<input type="radio" name="type" value="Présentiel">Présentiel<br>
									<input type="radio" name="type" value="En ligne">En ligne<br>
									<br><br>
									
									<input type="submit" value="Ajouter"><br><br>
								
								</form>
								<div class="cr">* Champs requis</div>
								</div>
			<jsp:include page="footer.jsp"/>