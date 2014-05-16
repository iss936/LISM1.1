						<jsp:include page="header.jsp"/>
						<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
						<div id="texte"><div id="overflow">
							<div class="cadre"><div class="titre"> Les cours </div><div class="marge_interne">

								<!-- Début de la zone de texte -->
								
								<ul>
									<c:forEach items="${lesCours}" var="unCours">
										<li>
											<a><c:out value="${unCours.libelleCours}" /></a>
										</li>
									</c:forEach>
								</ul>
								<jsp:include page="footer.jsp"/>