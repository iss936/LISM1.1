			<jsp:include page="header.jsp"/>
			<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
								<div class="titre">Ajouter un étudiant</div>
								<div class="marge_interne">

								<!-- Début de la zone de texte -->
								
								<form action="addEtudiant" method="post">
								
									<label for="prenom">Prénom</label>
									<input type="text" name="prenom"><br><br>
									
									<label for="nom">Nom</label>
									<input type="text" name="nom"><br><br>
									
									<label for="login">Login</label>
									<input type="text" name="login"><br><br>
									
									<label for="mdp">Mot de passe</label>
									<input type="password" name="mdp"><br><br>
									
									<label for="confirm">Confirmation</label>
									<input type="password" name="confirm"><br><br>
									
									<input type="submit" value="Ajouter">
								
								</form>
								</div>
			<jsp:include page="footer.jsp"/>