			<jsp:include page="header.jsp"/>
			<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
								<div class="titre">Ajouter une évaluation</div>
								<div class="marge_interne">

								<!-- Début de la zone de texte -->
								
								<form action="addEval" method="post">
								
									<label for="dateDebut">Date de début: </label>
									<input type="text" required="required" name="dateDebut" class="datepicker"><br><br>
									
									<label for="dateFin">Date de fin: </label>
									<input type="text" required="required" name="dateFin" class="datepicker"><br><br>
									
									<input type="hidden" value="${idCoursSession}" name="idCoursSession">
									
									<input type="submit" value="Ajouter"><br><br>
								
								</form>
								</div>
			<jsp:include page="footer.jsp"/>