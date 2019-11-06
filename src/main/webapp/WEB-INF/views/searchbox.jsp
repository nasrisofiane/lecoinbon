<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<link rel="stylesheet" href="css/style.css">
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<%@include file="head.jsp" %>
<body>
	<%@include file="header.jsp" %>
	<h2>Searchbox</h2>
	<div class="searchbox-annonces">
		<form action="http://localhost:8080/searchbox" method="GET">
			<fieldset>
				<legend>Search by</legend>
				  <input type="radio" id="titre" name="searchby" value="titre" checked>
				  <label for=""titre"">Titre</label>
				
				  <input type="radio" id="description" name="searchby" value="description">
				  <label for="description">Description</label>
			</fieldset>
			<input name="keyword" type="text"/>
			<input type="submit" value="Search"/>
		</form>
	</div>
	<div class="all-annonces">
		<p>searched Keyword : <strong><i>${keyword}</i></strong></p>
		<c:forEach items="${ annonces}" var="annonces">
			<div class="one-annonce">
				<h3>Titre : ${ searchby == "titre" ? annonces.titre.toLowerCase().replace(keyword, keywordStrong) : annonces.titre}</h3>
				<p>${searchby == "description" ? annonces.description.toLowerCase().replace(keyword, keywordStrong) : annonces.description }</p>
				<date>creation date : ${annonces.created}</date>
			</div>
		</c:forEach>
		<ul class="pagination">
		<c:forEach var = "i" begin = "1" end = "${nbpages+1}">
	        <li><a href="http://localhost:8080/searchbox?page=${i-1}&searchby=${searchby}&keyword=${keyword}">${i}</a></li>
	    </c:forEach>
	</ul>
	</div>
	<%@include file="footer.jsp" %>
</body>
</html>