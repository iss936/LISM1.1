<jsp:include page="header.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="titre">Mon Profil</div>
<div class="marge_interne">

	<!-- Début de la zone de texte -->
	<fieldset>
		<LEGEND align=top>Modifier votre mot de passe </LEGEND> 
		<form action="setMdp" method="post">
								
			<label for="oldMdp">Mot de passe actuel</label>
			<input type="password" name="oldMdp"><br><br>
									
			<label for="newMdp">Nouveau mot de passe</label>
			<input type="password" name="newMdp"><br><br>
									
			<label for="newMdpConfirm">Ressaisir le nouveau</label>
			<input type="password" name="newMdpConfirm"><br><br>
									
			<input type="submit" value="Valider"><br><br>
								
		</form>
	</fieldset>
</div>						
<jsp:include page="footer.jsp"/>