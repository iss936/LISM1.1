			<jsp:include page="header.jsp"/>
			<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
								<div class="titre">Ajouter un cours à un professeur</div>
								<div class="marge_interne">

								<!-- Début de la zone de texte -->
								
								<form action="AddCoursSessionItem" method="POST">
								
									<label for="professeur">Professeur *</label>
									  <select name="choixProf" required="required">
									  <c:forEach var="unEnseignant"  items="${enseignantList}" >
								          <option value="${unEnseignant.idEnseignant} ">
								          <c:out value="${unEnseignant.prenomEnseignant} ${unEnseignant.nomEnseignant}" /></option>
								          </c:forEach>         
								     </select><br><br>

									<label for="matiere">Matière *</label>
									  <select name="choixCoursSession" required="required">
								          <c:forEach var="unCoursSession"  items="${coursSessionList}" >
								          <option value="${unCoursSession.idCoursSession}">
								          <c:out value="${unCoursSession.description}"/></option>
								          </c:forEach>       
								     </select><br><br>
									
									<label for="salle">Salle *</label>
									 <select name="choixSalle" required="required">
								            <c:forEach var="unSalle"  items="${salleList}" >
								             <option value="${unSalle.idSalle} ">
								                  <c:out value="${unSalle.libelleSalle}"/></option>
								          </c:forEach>        
								     </select><br><br>
									
									<label for="date">Date *</label>
									<input type="text" required="required" name="date" class="datepicker"><br><br>
									
									<label for="description">Description *</label>
									<textarea rows="3" required="required" name="description" ></textarea><br><br>
									
									<input type="submit" value="Créer"><br><br>
								
								</form>
								<div class="cr">* Champs requis</div>
								</div>
			<jsp:include page="footer.jsp"/>