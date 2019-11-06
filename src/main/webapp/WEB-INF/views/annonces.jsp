<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<link rel="stylesheet" href="css/style.css">
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<%@include file="head.jsp" %>
<body>
	
	<%@include file="header.jsp" %>
	<h2>All annonces</h2>
	<div class="all-annonces">
		<c:forEach items="${annonces}" var="annonces">
			<div class="one-annonce">
				<h3>Titre : ${annonces.titre}</h3>
				<p><i>${annonces.description}</i></p>
				<date>creation date : ${annonces.created}</date>
			</div>
		</c:forEach>
		<ul class="pagination">
			<c:forEach var = "i" begin = "1" end = "${nbpages+1}">
	         <li><a href="http://localhost:8080/getAnnonces?page=${i-1}">${i}</a></li>
	      	</c:forEach>
		</ul>
	</div>
	<%@include file="footer.jsp" %>
</body>
</html>