<jsp:include page="header.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="${pageContext.request.contextPath}/resources/js/validateMonProfil.js" type="text/javascript"></script>
<div class="titre">Mon Profil</div>
<div class="marge_interne">

	<!-- Début de la zone de texte -->
	<fieldset>
		<LEGEND align=top>Modifier votre mot de passe </LEGEND> <br>
		<form name="setMdp" action="setMdp" method="post">
								
			<label for="oldMdp">Mot de passe actuel *</label>
			<input type="password" required="required" name="oldMdp"><br><br>
									
			<label for="newMdp">Nouveau mot de passe *</label>
			<input type="password" required="required" name="newMdp" id="newMdp"><br><br>
									
			<label for="newMdpConfirm">Ressaisir le nouveau *</label>
			<input type="password" required="required" onblur="verifConfirmationMdp(this)" name="newMdpConfirm"><br><br>
									
			<input type="submit" value="Valider"><br><br>
								
		</form>
		<div class="cr">* Champs requis</div>
	</fieldset>
</div>						
<jsp:include page="footer.jsp"/>