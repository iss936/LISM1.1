<jsp:include page="header.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="titre">Ajouter du contenu � un cours</div>
<div class="marge_interne">

	<!-- D�but de la zone de texte -->
								
	<form action="addContenu" method="post" enctype="multipart/form-data">
								
		<label for="contenu">Contenu du cours</label>
		<input type="file" name="contenu"><br><br>
									
		<input type="submit" value="Ajouter">
								
	</form>
</div>
<jsp:include page="footer.jsp"/>