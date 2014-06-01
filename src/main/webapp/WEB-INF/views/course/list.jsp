		<jsp:include page="../header.jsp"/>
		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
		<div class="titre">Les matières</div>
		<table>
									
			<c:forEach var="unCour"  items="${courseList}" >
			<tr>
				
				<td><a href="FicheCoursSession?idCours=${unCour.idCours}"><c:out value="${unCour.libelleCours}"/></a></td>
				
			</tr>
			</c:forEach> 
							
		</table>
		<jsp:include page="../footer.jsp"/>