			<jsp:include page="header.jsp"/>
			<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
								<div class="titre">Ajouter un cours à un professeur</div>
								<div class="marge_interne">

								<!-- Début de la zone de texte -->
								
								<form action="AddCoursSessionItem" method="POST">
								
									<label for="professeur">Professeur</label>
									  <select name="choixProf">
									  <c:forEach var="unEnseignant"  items="${enseignantList}" >
								          <option value="${unEnseignant.idEnseignant} ">
								          <c:out value="${unEnseignant.prenomEnseignant} ${unEnseignant.nomEnseignant}" /></option>
								          </c:forEach>         
								     </select><br><br>

									<label for="matiere">Matière</label>
									  <select name="choixCoursSession">
								          <c:forEach var="unCoursSession"  items="${coursSessionList}" >
								          <option value="${unCoursSession.idCoursSession}">
								          <c:out value="${unCoursSession.description}"/></option>
								          </c:forEach>       
								     </select><br><br>
									
									<label for="salle">Salle</label>
									 <select name="choixSalle">
								            <c:forEach var="unSalle"  items="${salleList}" >
								             <option value="${unSalle.idSalle} ">
								                  <c:out value="${unSalle.libelleSalle}"/></option>
								          </c:forEach>        
								     </select><br><br>
									
									<label for="date">Date</label>
									<input type="text" name="date" class="datepicker"><br><br>
									
									<label for="description">Description</label>
									<input type="text" name="description"><br><br>
									
									<input type="submit" value="Créer">
								
								</form>
								</div>
			<jsp:include page="footer.jsp"/>