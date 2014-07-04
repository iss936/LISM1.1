			<jsp:include page="header.jsp"/>
			<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
			<script src="${pageContext.request.contextPath}/resources/js/validateFrmAddEnseignant.js" type="text/javascript"></script>
								<div class="titre">Ajouter un professeur</div>
								<div class="marge_interne">

								<!-- Début de la zone de texte -->
								
								<form name="frmAddEnseignant" action="addEnseignant" method="post">
								
									<label for="prenom">Prénom *</label>
									<input type="text" required="required" onblur="verifPrenom(this)" name="prenom"><br><br>
									
									<label for="nom">Nom *</label>
									<input type="text" required="required" onblur="verifNom(this)" name="nom"><br><br>
									
									<label for="login">Login *</label>
									<input type="text" required="required" onblur="verifLogin(this)" name="login"><br><br>
									
									<label for="mdp">Mot de passe *</label>
									<input type="password" required="required" name="mdp" id="mdp" ><br><br>
									
									<label for="confirm">Confirmation *</label>
									<input type="password" required="required" onblur="verifConfirmationMdp(this)" name="confirm"><br><br>
									
									<input type="submit" value="Ajouter"><br><br>
								
								</form>
								<div class="cr">* Champs requis</div>
								</div>
			<jsp:include page="footer.jsp"/>