			<jsp:include page="header.jsp"/>
			<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
								<div class="titre">Mon Profil</div>
								<div class="marge_interne">

								<!-- Début de la zone de texte -->
								<fieldset>
								 <LEGEND align=top>Modifier votre MDP </LEGEND> 
								<form action="setMdp" method="post">
								
									<label for="oldMdp">Mots de passe actuel</label>
									<input type="password" name="oldMdp"><br><br>
									
									<label for="newMdp">Nouveau mots de passe</label>
									<input type="password" name="newMdp"><br><br>
									
									<label for="newMdpConfirm">Resaisir le nouveau</label>
									<input type="password" name="newMdpConfirm"><br><br>
									
									<input type="submit" value="Valider"><br><br>
								
								</form>
								</div>
								</fieldset>
								<div class="marge_interne">

								<!-- Début de la zone de texte -->
								<fieldset>
								 <LEGEND align=top>Modifier e-mail </LEGEND> 
								<form action="setMail" method="post">
								
									<label for="oldMdp">Saisir votre nouvelle email</label>
									<input type="text" name="oldMdp"><br><br>
									
									<input type="submit" value="Valider"><br><br>
								
								</form>
								</fieldset>
								<br>
								</div>  
			<jsp:include page="footer.jsp"/>