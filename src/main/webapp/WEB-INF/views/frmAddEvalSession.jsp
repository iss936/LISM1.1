			<jsp:include page="header.jsp"/>
			<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
								<div class="titre">Ajouter une �valuation</div>
								<div class="marge_interne">

								<!-- D�but de la zone de texte -->
								
								<form action="addEval" method="post">
								
									<label for="dateDebut">Date de d�but: </label>
									<input type="text" name="dateDebut"><br><br>
									
									<label for="dateFin">Date de fin: </label>
									<input type="text" name="dateFin"><br><br>
									
									<input type="hidden" value="${idCoursSession}" name="idCoursSession">
									
									<input type="submit" value="Ajouter">
								
								</form>
								</div>
			<jsp:include page="footer.jsp"/>