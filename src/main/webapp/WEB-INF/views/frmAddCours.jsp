			<jsp:include page="header.jsp"/>
			<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
								<div class="titre">Ajouter une matière</div>
								<div class="marge_interne">

								<!-- Début de la zone de texte -->
								
								<form action="addCours" method="post">
								
									<label for="libelle">Libelle *</label>
									<input type="text" name="libelle" required="required"><br><br>
									
									<input type="submit" value="Ajouter"><br><br>
								
								</form>
								<div class="cr">* Champs requis</div>
								</div>
			<jsp:include page="footer.jsp"/>