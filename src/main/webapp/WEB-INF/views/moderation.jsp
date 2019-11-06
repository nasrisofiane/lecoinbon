<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<link rel="stylesheet" href="css/style.css">
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<%@include file="head.jsp" %>
<body>
	
	<%@include file="header.jsp" %>
	<h2>Moderation</h2>
	<div class="all-annonces">
		<fieldset>
			<input type="radio" id="activated" name="annonces" value="activated" checked>
			<label for="activated">Activated</label>
			<input type="radio" id="disabled" name="annonces" value="disabled">
			<label for="disabled">Disabled</label>
		</fieldset>
		<c:if test="${annonces.size() > 0}">
			<form id="form-activated" action="http://localhost:8080/moderation" method="get" class="form-moderation">
				<c:forEach items="${annonces}" var="annonces">
					<div class="one-annonce">
						<h3>Titre : ${annonces.titre}</h3>
						<p><i>${annonces.description}</i></p>
						<date>creation date : ${annonces.created}</date>
						<input type="checkbox" name="annonceToActivate" value="${annonces.id}">Activate the annonce<br>
					</div>
				</c:forEach>
				 <input type="submit" value="Activate selected annonces">
			</form>
			<ul class="pagination">
				<c:forEach var = "i" begin = "1" end = "${nbpages+1}">
		         <li><a href="http://localhost:8080/moderation?page=${i-1}">${i}</a></li>
		      	</c:forEach>
			</ul>
		</c:if>
		<c:if test="${annonces.size() <1}">
			<div>NO ANNONCES TO BE ACTIVATED</div>
		</c:if>
		
		<c:if test="${annonces.size() > 0}">
			<form id="form-disabled" action="http://localhost:8080/moderation" method="get" class="form-moderation">
				<c:forEach items="${annonces}" var="annonces">
					<div class="one-annonce">
						<h3>ezfze : ${annonces.titre}</h3>
						<p><i>${annonces.description}</i></p>
						<date>creation date : ${annonces.created}</date>
						<input type="checkbox" name="annonceToActivate" value="${annonces.id}">Activate the annonce<br>
					</div>
				</c:forEach>
				 <input type="submit" value="Activate selected annonces">
			</form>
			<ul class="pagination">
				<c:forEach var = "i" begin = "1" end = "${nbpages+1}">
		         <li><a href="http://localhost:8080/moderation?page=${i-1}">${i}</a></li>
		      	</c:forEach>
			</ul>
		</c:if>
		<c:if test="${annonces.size() <1}">
			<div>NO ANNONCES TO BE ACTIVATED</div>
		</c:if>
	</div>
	
	
	<script type="text/javascript">
		const radioActivated = document.getElementById('activated');
		const radioDisabled = document.getElementById('disabled');
		const formActivated = document.getElementById('form-activated');
		const formDisabled = document.getElementById('form-disabled');
		radioActivated.addEventListener("click", ()=>{ formActivated.style.display = "flex" formDisabled.style.display = "none" });
		radioDisabled.addEventListener("click", ()=>{ formActivated.style.display = "none" ; formDisabled.style.display = "flex"}); 
	</script>
	<%@include file="footer.jsp" %>
</body>
</html>