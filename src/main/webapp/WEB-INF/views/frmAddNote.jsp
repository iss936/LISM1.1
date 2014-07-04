			<jsp:include page="header.jsp"/>
			<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
								<div class="titre">Déposer une note</div>
								<div class="marge_interne">

								<!-- Début de la zone de texte -->
								
								<form action="addNote" method="post">
								
									<label for="prenom">Prénom</label>
									<input type="text" required="required" name="prenom" value="${uneEval.etudiant.prenomEtudiant}" disabled="disabled"><br><br>
									
									<label for="nom">Nom</label>
									<input type="text" required="required" name="nom" value="${uneEval.etudiant.nomEtudiant}" disabled="disabled"><br><br>
									
									<label for="note">Note *</label>
									<input type="text" required="required" name="note">
									
									<input name="idEtudiant" value="${uneEval.etudiant.idEtudiant}" type="hidden">
									<input name="idEvalSession" value="${uneEval.evalSession.idEvalSession}" type="hidden">
									
									<input type="submit" value="Enregistrer"><br><br>
								
								</form>
								<div class="cr">* Champs requis</div>
								</div>
			<jsp:include page="footer.jsp"/>